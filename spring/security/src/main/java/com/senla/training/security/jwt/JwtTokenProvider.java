package com.senla.training.security.jwt;

import com.senla.training.dto.role.RoleDTO;
import com.senla.training.models.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:token.properties"})
public class JwtTokenProvider {

  private final UserDetailsService userDetailsService;

  @Value("${jwt.secret}")
  private String secretKey;

  @Value("${jwt.header}")
  private String authorizationHeader;

  @Value("${jwt.expiration}")
  private long validityInMilliseconds;

  public JwtTokenProvider(
      @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }

  @PostConstruct
  protected void init() {
    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
  }

  public String createToken(String username, Set<RoleDTO> roles) {
    Claims claims = Jwts.claims().setSubject(username);
    claims.put("role", getRoleNames(roles));
    Date now = new Date();
    Date validity = new Date(now.getTime() + validityInMilliseconds * 1000);

    return Jwts.builder()
        .setClaims(claims)
        .setIssuedAt(now)
        .setExpiration(validity)
        .signWith(SignatureAlgorithm.HS256, secretKey)
        .compact();
  }

  public boolean validateToken(String token) {
    try {
      Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
      return !claimsJws.getBody().getExpiration().before(new Date());
    } catch (JwtException | IllegalArgumentException e) {
      throw new JwtAuthenticationException(
          "JWT token is expired or invalid", HttpStatus.UNAUTHORIZED);
    }
  }

  public Authentication getAuthentication(String token) {
    UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
  }

  public String getUsername(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
  }

  public String resolveToken(HttpServletRequest request) {
    return request.getHeader(authorizationHeader);
  }

  private List<String> getRoleNames(Set<RoleDTO> userRoles) {
    List<String> result = new ArrayList<>();

    userRoles.forEach(role -> {
      result.add(role.getName());
    });

    return result;
  }
}

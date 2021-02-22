package com.velheor.carrental.service.impl;

import com.velheor.carrental.dao.api.BrandRepository;
import com.velheor.carrental.dto.BrandDTO;
import com.velheor.carrental.models.Brand;
import com.velheor.carrental.objectmapper.ObjectMapperUtils;
import com.velheor.carrental.service.api.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService implements IBrandService {

  private final BrandRepository brandRepository;

  private final ObjectMapperUtils objectMapperUtils;

  @Autowired
  BrandService(BrandRepository brandRepository, ObjectMapperUtils objectMapperUtils) {
    this.brandRepository = brandRepository;
    this.objectMapperUtils = objectMapperUtils;
  }

  @Override
  public BrandDTO findById(Integer id) {
    return brandRepository
        .findById(id)
        .map(brand -> objectMapperUtils.map(brand, BrandDTO.class))
        .orElse(null);
  }

  @Override
  public BrandDTO create(BrandDTO entityDTO) {
    return objectMapperUtils.map(
        brandRepository.save(objectMapperUtils.map(entityDTO, Brand.class)), BrandDTO.class);
  }

  @Override
  public BrandDTO update(BrandDTO entityDTO) {
    if (brandRepository.findById(entityDTO.getId()).isPresent()) {
      return objectMapperUtils.map(
          brandRepository.save(objectMapperUtils.map(entityDTO, Brand.class)), BrandDTO.class);
    }
    return null;
  }

  @Override
  public void delete(BrandDTO entityDTO) {
    brandRepository.delete(objectMapperUtils.map(entityDTO, Brand.class));
  }

  @Override
  public void deleteById(int id) {
    brandRepository.deleteById(id);
  }
}

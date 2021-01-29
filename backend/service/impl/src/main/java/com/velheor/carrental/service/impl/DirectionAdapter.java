package com.velheor.carrental.service.impl;

import com.velheor.carrental.models.enums.Direction;
import java.util.HashMap;
import java.util.Map;

public class DirectionAdapter {

  public static Map<String, Direction> converterMap(Map<String, String> fieldDirectionStringMap) {
    HashMap<String, Direction> fieldDirectionMap = new HashMap<>();
    fieldDirectionStringMap.forEach(
        (key, value) -> fieldDirectionMap.put(key, Direction.valueOf(value)));
    return fieldDirectionMap;
  }
}

package com.senla.training.service.impl;

import com.senla.training.models.enums.Direction;
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

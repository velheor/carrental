package com.senla.training.dto.car;

import com.senla.training.dto.category.CategoryDTO;
import com.senla.training.dto.pricehistory.PriceHistoryDTO;
import java.util.List;

public class CarWithModelCategoryPriceHistoryBrandDTO extends CarWithModelBrandDTO {
  private CategoryDTO category;

  private List<PriceHistoryDTO> priceHistoryList;

  public CategoryDTO getCategory() {
    return category;
  }

  public void setCategory(CategoryDTO category) {
    this.category = category;
  }

  public List<PriceHistoryDTO> getPriceHistoryList() {
    return priceHistoryList;
  }

  public void setPriceHistoryList(List<PriceHistoryDTO> priceHistoryList) {
    this.priceHistoryList = priceHistoryList;
  }
}

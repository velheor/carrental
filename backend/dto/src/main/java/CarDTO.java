import java.sql.Date;
import java.util.List;

public class CarDTO {
    private Integer id;

    private ModelDTO model;

    private String carType;

    private String fuelType;

    private Date productionDate;

    private Boolean transmission;

    private CategoryDTO category;

    private List<PriceHistoryDTO> priceHistories;

    private List<RentDTO> rents;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ModelDTO getModel() {
        return model;
    }

    public void setModel(ModelDTO model) {
        this.model = model;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Boolean getTransmission() {
        return transmission;
    }

    public void setTransmission(Boolean transmission) {
        this.transmission = transmission;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public List<PriceHistoryDTO> getPriceHistories() {
        return priceHistories;
    }

    public void setPriceHistories(List<PriceHistoryDTO> priceHistories) {
        this.priceHistories = priceHistories;
    }

    public List<RentDTO> getRents() {
        return rents;
    }

    public void setRents(List<RentDTO> rents) {
        this.rents = rents;
    }
}
import java.time.YearMonth;

public class CarSalesData {

    private String name;
    private String model;
    private YearMonth saleDate;
    private Integer salesCount;


    public CarSalesData(String name, String model, YearMonth saleDate, Integer salesCount) {
        this.name = name;
        this.model = model;
        this.saleDate = saleDate;
        this.salesCount = salesCount;


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "CarSalesData{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", saleDate=" + saleDate +
                ", salesCount=" + salesCount +
                '}';
    }

    public YearMonth getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(YearMonth saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Integer salesCount) {
        this.salesCount = salesCount;
    }


}

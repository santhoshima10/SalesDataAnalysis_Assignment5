import java.util.Date;

public class CarSalesData {

    private String name;
    private String model;
    private Date saleDate;
    private int salesCount;

    public int getSaleYear() {
        return saleYear;
    }

    public void setSaleYear(int saleYear) {
        this.saleYear = saleYear;
    }

    private int saleYear;

    public CarSalesData(String name, String model, Date saleDate, int salesCount, int saleYear) {
        this.name = name;
        this.model = model;
        this.saleDate = saleDate;
        this.salesCount = salesCount;
        this.saleYear = saleYear;

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

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }


}

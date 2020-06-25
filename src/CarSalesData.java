public class CarSalesData {

    private String name;
    private String model;
    private String saleDate;

    public CarSalesData(String name, String model, String saleDate, int salesCount) {
        this.name = name;
        this.model = model;
        this.saleDate = saleDate;
        this.salesCount = salesCount;
    }

    private int salesCount;


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

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }
}


import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;


public class SalesDataAnalysisApplication {

    List<CarSalesData> model3Data = new ArrayList<>();
    List<CarSalesData> modelSData = new ArrayList<>();
    List<CarSalesData> modelXData = new ArrayList<>();

    public static void main(String[] args){

        SalesDataAnalysisApplication salesDataAnalysisApplication = new SalesDataAnalysisApplication();


        salesDataAnalysisApplication.model3Data = FileService.processCSVFile("model3.csv", "Model 3");
        salesDataAnalysisApplication.modelSData = FileService.processCSVFile("modelS.csv", "Model S");
        salesDataAnalysisApplication.modelXData = FileService.processCSVFile("modelX.csv", "Model X");

        salesDataAnalysisApplication.generateCarSalesReport(salesDataAnalysisApplication.model3Data, "Model 3");
        salesDataAnalysisApplication.generateCarSalesReport(salesDataAnalysisApplication.modelSData, "Model S");
        salesDataAnalysisApplication.generateCarSalesReport(salesDataAnalysisApplication.modelXData, "Model X");


    }

    public void generateCarSalesReport(List<CarSalesData> salesData, String modelType) {

        System.out.println();
        System.out.println(modelType + " Yearly Sales Report");
        System.out.println("--------------------------------------------------");


        // We need to aggregate the sales yearwise . So we are using the grouping by year and getting the summary stats based on year
        //we are storing this into a map
        // From the map will be getting the year and corresponding sum from the stats.

        Map<Integer, IntSummaryStatistics> yearSales = salesData.stream()
                .collect(Collectors.groupingBy((a -> a.getSaleDate().getYear()), Collectors.summarizingInt(CarSalesData::getSalesCount)));

        yearSales.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue().getSum()));

        System.out.println();


        Optional<CarSalesData> maxCarSales = salesData.stream()
                .max((CarSalesData o1, CarSalesData o2) -> o1.getSalesCount().compareTo(o2.getSalesCount()));


        Optional<CarSalesData> minCarSales = salesData.stream()
                .min((CarSalesData o1, CarSalesData o2) -> o1.getSalesCount().compareTo(o2.getSalesCount()));


        System.out.println("The best month for " + modelType + " was: " + maxCarSales.map(a -> a.getSaleDate()).orElse(YearMonth.parse("1970-01")));
        System.out.println("The worst month for " + modelType + " was: " + minCarSales.map(a -> a.getSaleDate()).orElse(YearMonth.parse("1970-01")));





    }



}

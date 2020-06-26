import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


public class SalesDataAnalysisApplication {

    public static ArrayList<CarSalesData> model3Data = new ArrayList<>();
    public static ArrayList<CarSalesData> modelSData = new ArrayList<>();
    public static ArrayList<CarSalesData> modelXData = new ArrayList<>();

    public static void main(String[] args){
        FileService.processCSVFile("model3.csv");
        FileService.processCSVFile("modelS.csv");
        FileService.processCSVFile("modelX.csv");

        generateReportForModel3();
        generateReportForModelS();
        generateReportForModelX();


    }

    private static void generateReportForModel3(){

        System.out.println();
        System.out.println("Model 3 Yearly Sales Report");
        System.out.println("--------------------------------------------------");


        // We need to aggregate the sales yearwise . So we are using the grouping by year and getting the summary stats based on year
        //we are storing this into a map
        // From the map will be getting the year and corresponding sum from the stats.
        Map<Integer, IntSummaryStatistics> yearSales = model3Data.stream()
                .collect(Collectors.groupingBy(CarSalesData::getSaleYear, Collectors.summarizingInt(CarSalesData::getSalesCount)));

        yearSales.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue().getSum()));


        IntSummaryStatistics summaryStatisticsModel3 = model3Data.stream()
                .mapToInt(a -> a.getSalesCount())
                .summaryStatistics();

        Optional<Date> minSalesMonthOpt = Optional.empty();

        minSalesMonthOpt = model3Data.stream()
                .filter(y -> y.getSalesCount() == summaryStatisticsModel3.getMin() )
                .map(s -> s.getSaleDate())
                .findAny();

        Date minSalesMonthModel3 = minSalesMonthOpt.orElse(new Date());


        Optional<Date> maxSalesMonthOpt = Optional.empty();

        maxSalesMonthOpt = model3Data.stream()
                .filter(y -> y.getSalesCount() == summaryStatisticsModel3.getMax() )
                .map(s -> s.getSaleDate())
                .findAny();

        Date maxSalesMonthModel3 = maxSalesMonthOpt.orElse(new Date());

        DateFormat df = new SimpleDateFormat("MMM-yy");

        System.out.println();
        System.out.println("The best month for Model 3 was: " + df.format(maxSalesMonthModel3));
        System.out.println("The worst month for Model 3 was: " + df.format(minSalesMonthModel3));


    }

    private static void generateReportForModelS(){

        System.out.println();
        System.out.println("Model S Yearly Sales Report");
        System.out.println("--------------------------------------------------");


        Map<Integer, IntSummaryStatistics> yearSales = modelSData.stream()
                .collect(Collectors.groupingBy(CarSalesData::getSaleYear, Collectors.summarizingInt(CarSalesData::getSalesCount)));

        yearSales.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue().getSum()));


        IntSummaryStatistics summaryStatisticsModelS = modelSData.stream()
                .mapToInt(a -> a.getSalesCount())
                .summaryStatistics();

        Optional<Date> minSalesMonthOpt = Optional.empty();

        minSalesMonthOpt = modelSData.stream()
                .filter(y -> y.getSalesCount() == summaryStatisticsModelS.getMin() )
                .map(s -> s.getSaleDate())
                .findAny();

        Date minSalesMonthModelS = minSalesMonthOpt.orElse(new Date());


        Optional<Date> maxSalesMonthOpt = Optional.empty();

        maxSalesMonthOpt = modelSData.stream()
                .filter(y -> y.getSalesCount() == summaryStatisticsModelS.getMax() )
                .map(s -> s.getSaleDate())
                .findAny();

        Date maxSalesMonthModelS = maxSalesMonthOpt.orElse(new Date());


        DateFormat df = new SimpleDateFormat("MMM-yy");
        System.out.println();
        System.out.println("The best month for Model S was: " + df.format(maxSalesMonthModelS));
        System.out.println("The worst month for Model S was: " + df.format(minSalesMonthModelS));


    }


    private static void generateReportForModelX(){

        System.out.println();
        System.out.println("Model X Yearly Sales Report");
        System.out.println("--------------------------------------------------");


        Map<Integer, IntSummaryStatistics> yearSales = modelXData.stream()
                .collect(Collectors.groupingBy(CarSalesData::getSaleYear, Collectors.summarizingInt(CarSalesData::getSalesCount)));

        yearSales.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue().getSum()));


        IntSummaryStatistics summaryStatisticsModelX = modelXData.stream()
                .mapToInt(a -> a.getSalesCount())
                .summaryStatistics();

        Optional<Date> minSalesMonthOpt = Optional.empty();

        minSalesMonthOpt = modelXData.stream()
                .filter(y -> y.getSalesCount() == summaryStatisticsModelX.getMin() )
                .map(s -> s.getSaleDate())
                .findAny();

        Date minSalesMonthModelX = minSalesMonthOpt.orElse(new Date());

        Optional<Date> maxSalesMonthOpt = Optional.empty();

        maxSalesMonthOpt = modelXData.stream()
                .filter(y -> y.getSalesCount() == summaryStatisticsModelX.getMax() )
                .map(s -> s.getSaleDate())
                .findAny();

        Date maxSalesMonthModelX = maxSalesMonthOpt.orElse(new Date());


        DateFormat df = new SimpleDateFormat("MMM-yy");
        System.out.println();
        System.out.println("The best month for Model X was: " + df.format(maxSalesMonthModelX));
        System.out.println("The worst month for Model X was: " + df.format(minSalesMonthModelX));


    }


}

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.Optional;


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

        int salesAgg2017 = model3Data.stream()
                .filter(y -> y.getSaleDate().contains("-17"))
                .mapToInt(a -> a.getSalesCount())
                .sum();

        int salesAgg2018 = model3Data.stream()
                .filter(y -> y.getSaleDate().contains("-18"))
                .mapToInt(a -> a.getSalesCount())
                .sum();

        int salesAgg2019 = model3Data.stream()
                .filter(y -> y.getSaleDate().contains("-19"))
                .mapToInt(a -> a.getSalesCount())
                .sum();


        System.out.println("2017    -> "+salesAgg2017);
        System.out.println("2018    -> "+salesAgg2018);
        System.out.println("2019    -> "+salesAgg2019);


        //

        IntSummaryStatistics summaryStatisticsModel3 = model3Data.stream()
                .mapToInt(a -> a.getSalesCount())
                .summaryStatistics();

        Optional<String> minSalesMonthOpt = Optional.empty();

        minSalesMonthOpt = model3Data.stream()
                .filter(y -> y.getSalesCount() == summaryStatisticsModel3.getMin() )
                .map(s -> s.getSaleDate())
                .findAny();

        String minSalesMonthModel3 = minSalesMonthOpt.orElse("No Data");


        Optional<String> maxSalesMonthOpt = Optional.empty();

        maxSalesMonthOpt = model3Data.stream()
                .filter(y -> y.getSalesCount() == summaryStatisticsModel3.getMax() )
                .map(s -> s.getSaleDate())
                .findAny();

        String maxSalesMonthModel3 = maxSalesMonthOpt.orElse("No Data");



        System.out.println();
        System.out.println("The best month for Model 3 was: "+maxSalesMonthModel3);
        System.out.println("The worst month for Model 3 was: "+minSalesMonthModel3);


    }

    private static void generateReportForModelS(){

        System.out.println();
        System.out.println("Model S Yearly Sales Report");
        System.out.println("--------------------------------------------------");

        int salesAgg2016 = modelSData.stream()
                .filter(y -> y.getSaleDate().contains("-16"))
                .mapToInt(a -> a.getSalesCount())
                .sum();

        int salesAgg2017 = modelSData.stream()
                .filter(y -> y.getSaleDate().contains("-17"))
                .mapToInt(a -> a.getSalesCount())
                .sum();

        int salesAgg2018 = modelSData.stream()
                .filter(y -> y.getSaleDate().contains("-18"))
                .mapToInt(a -> a.getSalesCount())
                .sum();

        int salesAgg2019 = modelSData.stream()
                .filter(y -> y.getSaleDate().contains("-19"))
                .mapToInt(a -> a.getSalesCount())
                .sum();


        System.out.println("2016    -> "+salesAgg2016);
        System.out.println("2017    -> "+salesAgg2017);
        System.out.println("2018    -> "+salesAgg2018);
        System.out.println("2019    -> "+salesAgg2019);


        //

        IntSummaryStatistics summaryStatisticsModelS = modelSData.stream()
                .mapToInt(a -> a.getSalesCount())
                .summaryStatistics();

        Optional<String> minSalesMonthOpt = Optional.empty();

        minSalesMonthOpt = modelSData.stream()
                .filter(y -> y.getSalesCount() == summaryStatisticsModelS.getMin() )
                .map(s -> s.getSaleDate())
                .findAny();

        String minSalesMonthModelS = minSalesMonthOpt.orElse("No Data");


        Optional<String> maxSalesMonthOpt = Optional.empty();

        maxSalesMonthOpt = modelSData.stream()
                .filter(y -> y.getSalesCount() == summaryStatisticsModelS.getMax() )
                .map(s -> s.getSaleDate())
                .findAny();

        String maxSalesMonthModelS = maxSalesMonthOpt.orElse("No Data");



        System.out.println();
        System.out.println("The best month for Model S was: "+maxSalesMonthModelS);
        System.out.println("The worst month for Model S was: "+minSalesMonthModelS);


    }

    private static void generateReportForModelX(){

        System.out.println();
        System.out.println("Model X Yearly Sales Report");
        System.out.println("--------------------------------------------------");

        int salesAgg2016 = modelXData.stream()
                .filter(y -> y.getSaleDate().contains("-16"))
                .mapToInt(a -> a.getSalesCount())
                .sum();

        int salesAgg2017 = modelXData.stream()
                .filter(y -> y.getSaleDate().contains("-17"))
                .mapToInt(a -> a.getSalesCount())
                .sum();

        int salesAgg2018 = modelXData.stream()
                .filter(y -> y.getSaleDate().contains("-18"))
                .mapToInt(a -> a.getSalesCount())
                .sum();

        int salesAgg2019 = modelXData.stream()
                .filter(y -> y.getSaleDate().contains("-19"))
                .mapToInt(a -> a.getSalesCount())
                .sum();


        System.out.println("2016    -> "+salesAgg2016);
        System.out.println("2017    -> "+salesAgg2017);
        System.out.println("2018    -> "+salesAgg2018);
        System.out.println("2019    -> "+salesAgg2019);


        //

        IntSummaryStatistics summaryStatisticsModelX = modelXData.stream()
                .mapToInt(a -> a.getSalesCount())
                .summaryStatistics();


        Optional<String> minSalesMonthOpt = Optional.empty();

        minSalesMonthOpt = modelXData.stream()
                .filter(y -> y.getSalesCount() == summaryStatisticsModelX.getMin() )
                .map(s -> s.getSaleDate())
                .findAny();

        String minSalesMonthModelX = minSalesMonthOpt.orElse("No Data");


        Optional<String> maxSalesMonthOpt = Optional.empty();

        maxSalesMonthOpt = modelXData.stream()
                .filter(y -> y.getSalesCount() == summaryStatisticsModelX.getMax() )
                .map(s -> s.getSaleDate())
                .findAny();

        String maxSalesMonthModelX = maxSalesMonthOpt.orElse("No Data");



        System.out.println();
        System.out.println("The best month for Model X was: "+maxSalesMonthModelX);
        System.out.println("The worst month for Model X was: "+minSalesMonthModelX);


    }
}

import java.io.*;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



public class FileService {


    public static List<CarSalesData> processCSVFile(String filename, String modelType) {

        BufferedReader reader = null;
        String line = null;
        List<CarSalesData> carSalesList = new ArrayList<>();

        try{
            reader = new BufferedReader(new FileReader(filename));
            line = reader.readLine();
            line = null;
            line = reader.readLine();

            while(line!=null){
                //processData(line,"model3",filename);

                String dateOfSales = line.split(",")[0];
                YearMonth yearMonth = YearMonth.parse(dateOfSales, DateTimeFormatter.ofPattern("MMM-yy"));
                int sales = Integer.parseInt(line.split(",")[1]);
                CarSalesData lineData = new CarSalesData("Tesla", modelType, yearMonth, sales);
                carSalesList.add(lineData);
                line = reader.readLine();
            }


        }
        catch (IOException e){
            e.printStackTrace();
        }
        return carSalesList;

    }


}

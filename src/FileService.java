import java.io.*;


public class FileService {


    public static void processCSVFile(String filename){

        BufferedReader reader = null;
        String line = null;

        try{
            reader = new BufferedReader(new FileReader(filename));
            line = reader.readLine();
            line = null;
            line = reader.readLine();

            while(line!=null){
                processData(line,"model3",filename);
                line = reader.readLine();
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void  processData(String line, String model, String filename){

       String dateOfSales = line.split(",")[0];
       int sales = Integer.parseInt(line.split(",")[1]);

       CarSalesData lineData = new CarSalesData("Tesla",model,dateOfSales,sales);

       if (filename.equals("model3.csv")) {

           SalesDataAnalysisApplication.model3Data.add(lineData);
       }
        else if (filename.equals("modelS.csv")) {

            SalesDataAnalysisApplication.modelSData.add(lineData);
        }
        else if (filename.equals("modelX.csv")) {

            SalesDataAnalysisApplication.modelXData.add(lineData);
        }




    }
}

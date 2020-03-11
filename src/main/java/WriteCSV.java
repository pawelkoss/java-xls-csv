import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WriteCSV {

    public static void writeDataAtOnce(String filePath, LinkedList<SingleRow> dane)
    {

        // first create file object for file placed at location
        // specified by filepath
        File file = new File(filePath);

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // create a List which contains String array
            List<String[]> data = new ArrayList<String[]>();
 /*           data.add(new String[] { "Name", "Class", "Marks" });
            data.add(new String[] { "Aman", "10", "620" });
            data.add(new String[] { "Suraj", "10", "630" });
            writer.writeAll(data);*/
            data.add(new String[] { "ID", "Stan", "miasto", "CLF2007", "EMP2007", "UEMP2007" });


            for(SingleRow item:dane){
                System.out.println(item.CLF2007);
                data.add(new String[] { String.valueOf(item.id), item.skrot, item.city, String.valueOf(item.CLF2007), String.valueOf(item.EMP2007), String.valueOf(item.UEMP2007) });
            }
            writer.writeAll(data);
            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

import static oracle.jrockit.jfr.events.Bits.intValue;

public class Main {

    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream(
                new File("C:\\Users\\Nata\\Documents\\CSchool\\ConnectisMVN\\src\\main\\resources\\Unemployment.xls"));
        HSSFWorkbook workbook = new HSSFWorkbook(file);

        LinkedList<SingleRow> dane = new LinkedList<SingleRow>();



        // System.out.println(workbook.getSheetAt(0).getHeader().toString());
        // workbook.getSheetAt(0).getRow(0).getLastCellNum();
        for(int i=9; i<3000; i++) {
/*            System.out.print(workbook.getSheetAt(0).getRow(i).getCell(0));
            System.out.print(" | ");
            System.out.print(workbook.getSheetAt(0).getRow(i).getCell(1));
            System.out.print(" | ");
            System.out.print(workbook.getSheetAt(0).getRow(i).getCell(2));
            System.out.print(" | ");
            System.out.print(workbook.getSheetAt(0).getRow(i).getCell(3));
            System.out.println();*/



            SingleRow wiersz = new SingleRow(
                    intValue(workbook.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue()),
                    workbook.getSheetAt(0).getRow(i).getCell(1).getStringCellValue(),
                    workbook.getSheetAt(0).getRow(i).getCell(2).getStringCellValue(),
                    intValue(workbook.getSheetAt(0).getRow(i).getCell(6).getNumericCellValue()),
                    intValue(workbook.getSheetAt(0).getRow(i).getCell(7).getNumericCellValue()),
                    intValue(workbook.getSheetAt(0).getRow(i).getCell(8).getNumericCellValue())
            );
            if (wiersz.CLF2007 > 0) {
                dane.add(wiersz);
            }else
                {continue;}

        }

/*        for(SingleRow item:dane){
            System.out.println(item.toString());
        }*/

        Collections.sort(dane, new SortCity());

        System.out.println("Posortowane wg City");

/*        for(SingleRow item:dane){
            System.out.println(item.toString());
        }*/

        //Collections.sort(dane, new SortCLFComparator().reversed());

        //System.out.println("Posortowane wg CLF");

/*        for(SingleRow item:dane){
            System.out.println(item.CLF2007);
        }*/


//WriteCSV.writeDataAtOnce("C:\\Users\\Nata\\Documents\\CSchool\\ConnectisMVN\\src\\main\\resources\\out.csv", dane);

        ExcelWriter.writeXLS(dane);
    }
}

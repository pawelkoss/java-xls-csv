import com.sun.media.sound.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


public class ExcelWriter {
    private static String[] columns = {"ID", "Stan", "miasto", "CLF2007", "EMP2007", "UEMP2007"};




    public static void writeXLS(LinkedList<SingleRow> dane) throws IOException, InvalidFormatException {
        // Create a Workbook
        Workbook workbook = new HSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances of various things like DataFormat,
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Statystyka");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }



        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(SingleRow item: dane) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(item.getId());

            row.createCell(1)
                    .setCellValue(item.getSkrot());
            row.createCell(2)
                    .setCellValue(item.getCity());
            row.createCell(3)
                    .setCellValue(item.getCLF2007());
            row.createCell(4)
                    .setCellValue(item.getEMP2007());
            row.createCell(5)
                    .setCellValue(item.getUEMP2007());

        }

        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Nata\\Documents\\CSchool\\ConnectisMVN\\src\\main\\resources\\out.xls");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
}

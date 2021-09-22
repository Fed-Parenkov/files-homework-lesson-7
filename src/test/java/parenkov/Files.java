package parenkov;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class Files {


        @Test
    void pdfTest() throws Exception {

        try (InputStream file = getClass().getClassLoader().getResourceAsStream("pdfTestFile.pdf")) {
            PDF parsed = new PDF(file);
            assertThat(parsed.text).contains("SDET (Software Development Engineer in Test) " +
                    "инженер по разработке ПО в тестировании");
        }
    }


        @Test
    void xlsxTest() throws Exception {

        try (InputStream file = getClass().getClassLoader().getResourceAsStream("xlsxTestFile.xlsx")) {
            XLS parsed = new XLS(file);
            assertThat(parsed.excel.getSheetAt(0).getRow(8).getCell(1).getStringCellValue())
                    .isEqualTo("Нагель (шкант) берёзовый Нагель 10x150мм цена за штуку ");
        }
    }




        @Test
    void txtTest() throws Exception {

            try (InputStream is = getClass().getClassLoader().getResourceAsStream("txtTestFile.txt")) {
                Scanner scan = new Scanner(is);


                while (scan.hasNextLine()) {
                    System.out.println(scan.nextLine());
                }
            }
        }






}

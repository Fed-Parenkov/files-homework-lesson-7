package parenkov;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
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
        String result;

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("txtTestFile.txt")) {
            result = new String(is.readAllBytes(), "UTF-8");
        }
        assertThat(result).contains("SDET (Software Development Engineer in Test)" +
                " инженер по разработке ПО в тестировании");
    }







}
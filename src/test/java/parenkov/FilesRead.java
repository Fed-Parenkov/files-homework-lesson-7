package parenkov;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;


public class FilesRead {

    @Test
    void pdfTest() throws Exception {

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("pdf.pdf")) {
            PDF parsed = new PDF(is);
            assertThat(parsed.text).contains("SDET (Software Development Engineer in Test) " +
                    "инженер по разработке ПО в тестировании");
        }
    }

    @Test
    void xlsxTest() throws Exception {

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("xlsx.xlsx")) {
            XLS parsed = new XLS(is);
            assertThat(parsed.excel.getSheetAt(0).getRow(8).getCell(1).getStringCellValue())
                    .isEqualTo("Нагель (шкант) берёзовый Нагель 10x150мм цена за штуку ");
        }
    }

    @Test
    void txtTest() throws Exception {
        String result;
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("txt.txt")) {
            result = new String(is.readAllBytes(), "UTF-8");
            assertThat(result).contains("SDET (Software Development Engineer in Test)" +
                    " инженер по разработке ПО в тестировании");
        }
    }

    @Test
    void docxTest() throws Exception {
        String result;

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("docx.docx")) {
            XWPFDocument document = new XWPFDocument(is);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for (XWPFParagraph docxText : paragraphs) {
                result = docxText.getText();
                assertThat(result).contains("SDET (Software Development Engineer in Test)" +
                        " инженер по разработке ПО в тестировании");
            }
        }
    }


    @Test
    void zipTest() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("zip.zip")) {
            ZipInputStream zis = new ZipInputStream(is);
            zis.getNextEntry();
            Scanner sc = new Scanner(zis, "UTF-8");
            String firstLineInTheTextFile = sc.nextLine();
            assertThat(firstLineInTheTextFile).contains("SDET (Software Development Engineer in Test)" +
                    " инженер по разработке ПО в тестировании");
        }
    }



//    @Test
//    void zipProtectedTest() throws Exception {
//        try (InputStream is = getClass().getClassLoader().getResourceAsStream("zipProtected.zip")) {
//            ZipInputStream zis = new ZipInputStream(is);
//            zis.getNextEntry();
//            Scanner sc = new Scanner(zis, "UTF-8");
//            while (sc.hasNextLine()) {
//                System.out.println(sc.nextLine());
//            }
//        }


}





package parenkov;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import net.lingala.zip4j.ZipFile;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

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
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("txt.txt")) {
            String result = new String(is.readAllBytes(), "UTF-8");
            assertThat(result).contains("SDET (Software Development Engineer in Test)" +
                    " инженер по разработке ПО в тестировании");
        }
    }

    @Test
    void docxTest() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("docx.docx")) {
            XWPFDocument document = new XWPFDocument(is);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for (XWPFParagraph docxText : paragraphs) {
                String result = docxText.getText();
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

    @Test
    // unzip the protected archive and read txt file
    void zipProtectedTest() throws Exception {
        String source = "./src/test/resources/zipProtected.zip";
        String destination = "./src/test/resources/";
        String password = "qwerty";
        try (ZipFile zipFile = new ZipFile(source)) {
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(password.toCharArray());
            }
            zipFile.extractAll(destination);
        }
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("txt111.txt")) {
            String result = new String(is.readAllBytes(), "UTF-8");
            assertThat(result).contains("SDET (Software Development Engineer in Test)" +
                    " инженер по разработке ПО в тестировании");
        }
    }
}









package parenkov;


import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class FileTest {

//    @Test
//    void txtTest() throws Exception {
//
//        InputStream file = getClass().getClassLoader().getResourceAsStream("TestFile.txt");
//        try (InputStream is = new FileInputStream(file)) {
//            //result = new String(is.readAllBytes(), "UTF-8");
//        }
//        //assertThat(result).contains("Selenide = UI Testing Framework powered by Selenium WebDriver");
//
////        PDF parsed = new PDF(download);
////        assertThat(parsed.author).contains("Marc Philipp");
//    }
//}





//    @Test
//    void pdfTest() throws Exception {
//
//        try (InputStream file = getClass().getClassLoader().getResourceAsStream("pdfTestFile.pdf")) {
//            PDF parsed = new PDF(file);
//            assertThat(parsed.text).contains("Software Development Engineer in Test");
//        }
//    }




//    @Test
//    void xlsxTest() throws Exception {
//
//        try (InputStream file = getClass().getClassLoader().getResourceAsStream("xlsxTestFile.xlsx")) {
//            XLS parsed = new XLS(file);
//            assertThat(parsed.excel.getSheetAt(0).getRow(8).getCell(1).getStringCellValue())
//                    .isEqualTo("Нагель (шкант) берёзовый Нагель 10x150мм цена за штуку ");
//        }
//    }





//    @Test
//    void txtTest() throws Exception {
//        URL url = getClass().getClassLoader().getResource("txtTestFile.txt");
//        File file = new File(url.toURI());

//        List<String[]> strings = file.read();
//
//        assertThat(strings).contains(
//                new String[] {"lector", "lecture"},
//                new String[] {"Tuchs", "JUnit"},
//                new String[] {"Eroshenko", "Allure"}
//        );
//    }


//            assertThat(parsed.excel.getSheetAt(0).getRow(8).getCell(1).getStringCellValue())
//                    .isEqualTo("Нагель (шкант) берёзовый Нагель 10x150мм цена за штуку ");
//
//    }


//        @Test
//        void zipTest() throws Exception {
//
//            try (InputStream is = getClass().getClassLoader().getResourceAsStream("zipTestFile.zip")) {
//                ZipInputStream zis = new ZipInputStream(is);
//                Scanner sc = new Scanner(zis);
//                while (sc.hasNext()) {
//                    System.out.println(sc.nextLine());
//                }
//            }
//
//
//        }


//    @Test
//    void txtTest() throws Exception {
//
//        FileReader fr = new FileReader("txtTestFile.txt");
//        Scanner scan = new Scanner(fr);
//    }

//        int i = 1;
//
//        while (scan.hasNextLine()) {
//            System.out.println(i + " : " + scan.nextLine());
//            i++;
//        }
//
//        fr.close();
//    }


//        while(in.hasNext()) {
//            sb.append(in.next());
//        }
//        in.close();
//        outString = sb.toString();
//    }








}





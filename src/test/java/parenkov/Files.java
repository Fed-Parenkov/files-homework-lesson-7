package parenkov;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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




//        @Test
//    void txtTest() throws Exception {
//
//            String result;
//
//            try (InputStream iss = getClass().getClassLoader().getResourceAsStream("txtTestFile.txt")) {
//                result = new String(iss.readAllBytes(), "UTF-8");
//            }
//            assertThat(result).contains("SDET (Software Development Engineer in Test) " +
//                    "инженер по разработке ПО в тестировании");
//        }





//            File file = new File("C:\\Users\\Admin\\IdeaProjects\\files-homework-lesson-7\\src\\test\\resources\\txtTestFile.txt");
//            InputStream file = getClass().getClassLoader().getResourceAsStream("txtTestFile.txt");
//            InputStreamReader isr = null;
//            isr = new InputStreamReader(file, "UTF-8");
//            while(isr.) {
//                System.out.println(scan.nextLine());


//            Scanner scan = new Scanner(file);
//            while(scan.hasNextLine()) {
//                System.out.println(scan.nextLine());
//            }
//        }


//
//            try {
//                File file = new File("C:\\Users\\Admin\\IdeaProjects\\files-homework-lesson-7\\src\\test\\resources\\txtTestFile.txt");
//                //создаем объект FileReader для объекта File
//                FileReader fr = new FileReader(file);
//                //создаем BufferedReader с существующего FileReader для построчного считывания
//                BufferedReader reader = new BufferedReader(fr);
//                // считаем сначала первую строку
//                String line = reader.readLine();
//                while (line != null) {
//                    System.out.println(line);
//                    // считываем остальные строки в цикле
//                    line = reader.readLine();
//                }
//            }
//            catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }

//                String txtFilePath = "C:\\Users\\Admin\\IdeaProjects\\files-homework-lesson-7\\src\\test\\resources\\txtTestFile.txt";
//            File file = new File(txtFilePath);
//            try (InputStreamReader fr = new InputStreamReader(new FileInputStream(file), "UTF-8")) {
//
//                Scanner scan = new Scanner(fr);
//                while (scan.hasNextLine()) {
//                    System.out.println(scan.nextLine());
//
//                }

//            try (InputStream is = getClass().getClassLoader().getResourceAsStream("txtTestFile.txt")) {
//
//
//
//                Scanner scan = new Scanner(is);
//                String input = scan.nextLine();
//                System.out.println(input);
//                assertThat(input.getBytes()).isEqualTo("SDET");

//
//
//                while (scan.hasNextLine()) {
//                    System.out.println(scan.nextLine());
//                }



}










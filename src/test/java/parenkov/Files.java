package parenkov;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Document;
import org.docx4j.wml.Text;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

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

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("xlsxTestFile.xlsx")) {
            XLS parsed = new XLS(is);
            assertThat(parsed.excel.getSheetAt(0).getRow(8).getCell(1).getStringCellValue())
                    .isEqualTo("Нагель (шкант) берёзовый Нагель 10x150мм цена за штуку ");
        }
    }


    @Test
    void xlsTest() throws Exception {

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("xlsTestFile.xls")) {
            XLS parsed = new XLS(is);
            assertThat(parsed.excel.getSheetAt(0).getRow(8).getCell(1).getStringCellValue())
                    .isEqualTo("Нагель (шкант) берёзовый Нагель 10x150мм цена за штуку ");
        }
    }


    @Test
    void txtTest() throws Exception {
        String result;

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("txtTestFile.txt")) {
            result = new String(is.readAllBytes(), "UTF-8");

            assertThat(result).contains("SDET (Software Development Engineer in Test)" +
                    " инженер по разработке ПО в тестировании");
        }
    }


    @Test
    void docxTest() throws Exception {
        String result;

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("docxTestFile.docx")) {
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
    void docTest() throws Exception {
        String result;

        try (InputStream is = getClass().getClassLoader().getResourceAsStream("docTestFile.doc")) {
            XWPFDocument document = new XWPFDocument(is);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for (XWPFParagraph docxText : paragraphs) {
                result = docxText.getText();

                assertThat(result).contains("SDET (Software Development Engineer in Test)" +
                        " инженер по разработке ПО в тестировании");
            }
        }
    }







}










//        try (InputStream is = getClass().getClassLoader().getResourceAsStream("docxTestFile.docx")) {
//            WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(is);
//            MainDocumentPart mainDocumentPart = wordMLPackage.getMainDocumentPart();
//
//
////            System.out.println(mainDocumentPart.getXML());
////            assertThat(mainDocumentPart).isEqualTo("SDET (Software Development Engineer in Test)");
//
//            String textNodesXPath = "//w:t";
//            List<Object> textNodes= mainDocumentPart.getJAXBNodesViaXPath(textNodesXPath, true);
//
//
//            for (Object jaxbNode : textNodes){
//                final String paragraphString = jaxbNode.toString();
//                System.out.println(paragraphString);
//            }
//
//            Text text = (Text) ((JAXBElement) obj).getValue();
//                String textValue = text.getValue();
//                System.out.println(textValue);




//        try (FileInputStream fis = new FileInputStream("docxTestFile.docx")) {
//            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
//            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
//            System.out.println(extractor.getText());
//        }
//            assertThat(extractor).isEqualTo("SDET (Software Development Engineer in Test)");






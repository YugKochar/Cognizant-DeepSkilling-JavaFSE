package FactoryMethodPatternExample;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Document Management System (Factory Method) --- \n");

        // 1. Create and test Word Document using its concrete factory
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document myWordDoc = wordFactory.createDocument();
        myWordDoc.open();
        myWordDoc.close();

        System.out.println("\n------------------------------------------------\n");

        // 2. Create and test PDF Document using its concrete factory
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document myPdfDoc = pdfFactory.createDocument();
        myPdfDoc.open();
        myPdfDoc.close();

        System.out.println("\n------------------------------------------------\n");

        // 3. Create and test Excel Document using its concrete factory
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document myExcelDoc = excelFactory.createDocument();
        myExcelDoc.open();
        myExcelDoc.close();
    }
}
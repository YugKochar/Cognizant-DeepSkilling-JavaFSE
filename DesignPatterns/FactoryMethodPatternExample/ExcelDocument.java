package FactoryMethodPatternExample;

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel Document... (.xlsx processing spreadsheets)");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel Document. Formulas and cells locked.");
    }
}
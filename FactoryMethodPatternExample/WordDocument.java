package FactoryMethodPatternExample;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document... (.docx ready for editing)");
    }

    @Override
    public void close() {
        System.out.println("Closing Word Document. Changes auto-saved.");
    }
}
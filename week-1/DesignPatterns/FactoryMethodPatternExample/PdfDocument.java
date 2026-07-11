package FactoryMethodPatternExample;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document... (Read-Only Mode via PDF Viewer)");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF Document. Releasing memory stream.");
    }
}
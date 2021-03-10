package patterns.factory_method;

public class DocumentsPrinter {
    private DocumentGenerator generator;

    public void setGenerator(DocumentGenerator generator) {
        this.generator = generator;
    }

    public void printDocument(String text) {
        Document document = generator.generate(text);
        System.out.println("------ " + document.getTitle() + " --------");
        System.out.println(text);
    }
}

package patterns.factory_method;

public class Statement implements Document {

    private String text;
    private String title;

    public Statement(String title, String text) {
        this.text = text;
        this.title = title;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getTitle() {
        return title;
    }
}

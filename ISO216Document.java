public class ISO216Document {
    private int width;
    private int height;

    public ISO216Document(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public ISO216Document(String size) {
        switch (size.toUpperCase()) {
        case "A3":
            this.setWidth(297);
            this.setHeight(420);
            break;
        case "A4":
        case "":
        default:
            this.setWidth(210);
            this.setHeight(297);
            break;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

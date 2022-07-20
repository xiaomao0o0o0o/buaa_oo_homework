public class Item {
    private char sign;
    private String content;

    public Item(char sign, String content) {
        this.sign = sign;
        this.content = content;
    }

    public char getSign() {
        return sign;
    }

    public String getContent() {
        return content;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }
}

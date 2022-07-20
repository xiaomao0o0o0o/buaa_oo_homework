import java.util.ArrayList;

public class Mul {
    private ArrayList<Item> str1;
    private ArrayList<Item> str2;
    private ArrayList<Item> result = new ArrayList<>();

    public Mul(ArrayList<Item> str1, ArrayList<Item> str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public ArrayList<Item> getResult() {
        for (int i = 0; i < str1.size(); i++) {
            for (int j = 0; j < str2.size(); j++) {
                char sign;
                String content;
                if (str1.get(i).getSign() != str2.get(j).getSign()) {
                    sign = '-';
                } else {
                    sign = '+';
                }
                content = str1.get(i).getContent() + "*" + str2.get(j).getContent();
                Item item = new Item(sign, content);
                result.add(item);
            }
        }
        return result;
    }
}

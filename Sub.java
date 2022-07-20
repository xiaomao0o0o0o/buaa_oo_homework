import java.util.ArrayList;

public class Sub {
    private ArrayList<Item> str1;
    private ArrayList<Item> str2;
    private ArrayList<Item> result = new ArrayList<>();

    public Sub(ArrayList<Item> str1, ArrayList<Item> str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public ArrayList<Item> getResult() {
        result.addAll(str1);
        for (Item i : str2) {
            if (i.getSign() == '-') {
                i.setSign('+');
            } else {
                i.setSign('-');
            }
        }
        result.addAll(str2);
        return result;
    }
}

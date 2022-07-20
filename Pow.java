import java.util.ArrayList;

public class Pow {
    private ArrayList<Item> str1;
    private int num;
    private ArrayList<Item> result;

    public Pow(ArrayList<Item> str1, int num) {
        this.str1 = str1;
        this.num = num;
    }

    public ArrayList<Item> getResult() {
        ArrayList<Item> strZero = new ArrayList<>(str1);
        if (num == 0) {
            strZero.clear();
            strZero.add(new Item('+', "1"));
            return strZero;
        }
        while (num > 1) {
            ArrayList<Item> temp = new ArrayList<>(strZero);
            strZero.clear();
            strZero.addAll(getN(temp));
            num = num - 1;
        }
        return strZero;
    }

    private ArrayList<Item> getN(ArrayList<Item> strN) {
        ArrayList<Item> n = new ArrayList<>();
        for (int i = 0; i < str1.size(); i++) {
            for (int j = 0; j < strN.size(); j++) {
                if (str1.get(i).getSign() != strN.get(j).getSign()) {
                    n.add(new Item('-', strN.get(j).getContent() + "*" + str1.get(i).getContent()));
                } else {
                    n.add(new Item('+', strN.get(j).getContent() + "*" + str1.get(i).getContent()));
                }
            }
        }
        return n;
    }
}

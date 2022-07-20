import java.util.ArrayList;

public class Sin {
    private ArrayList<Item> str1;

    public Sin(ArrayList<Item> str1) {
        this.str1 = str1;
    }

    public ArrayList<Item> getResult() {
        String strSin = "sin(";
        boolean flag;
        if (str1.size() > 1) {
            flag = true;
        } else if (str1.get(0).getContent().contains("*")) {
            flag = true;
        } else {
            flag = false;
        }
        if (flag) {
            strSin = strSin + "(";
        }
        for (int i = 0; i < str1.size(); i++) {
            if (i == 0 && str1.get(i).getSign() == '+') {
                strSin = strSin + str1.get(i).getContent();
            } else {
                if (str1.get(i).getSign() == '-') {
                    strSin = strSin + "-" + str1.get(i).getContent();
                } else {
                    strSin = strSin + "+" + str1.get(i).getContent();
                }
            }
        }
        strSin = strSin + ")";
        if (flag) {
            strSin = strSin + ")";
        }
        char sign = '+';
        ArrayList<Item> result = new ArrayList<>();
        result.add(new Item(sign, strSin));
        return result;
    }
}

import java.util.ArrayList;

public class Cos {
    private ArrayList<Item> str1;

    public Cos(ArrayList<Item> str1) {
        this.str1 = str1;
    }

    public ArrayList<Item> getResult() {
        String strSin = "cos(";
        boolean flag = false;
        if (str1.size() > 1) {
            flag = true;
        } else if (str1.get(0).getContent().contains("*")) {
            String strTemp = str1.get(0).getContent();
            int temp = 0;
            for (int i = 0; i < strTemp.length(); i++) {
                if (strTemp.charAt(i) == '(') {
                    temp = temp + 1;
                }
                if (strTemp.charAt(i) == ')') {
                    temp = temp - 1;
                }
                if (strTemp.charAt(i) == '*') {
                    if (temp == 0) {
                        flag = true;
                    }
                }
            }
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
        if (flag) {
            strSin = strSin + ")";
        }
        strSin = strSin + ")";
        char sign = '+';
        ArrayList<Item> result = new ArrayList<>();
        //System.out.print(strSin+"here");
        result.add(new Item(sign, strSin));
        return result;
    }
}

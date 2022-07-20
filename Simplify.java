import java.util.ArrayList;

public class Simplify {
    private ArrayList<Item> input = new ArrayList<>();

    public Simplify(ArrayList<Item> input) {
        this.input = input;
    }

    public ArrayList<Item> cal() {
        for (int i = 0; i < input.size(); i++) {
            String temp = input.get(i).getContent();
            ArrayList<Character> result = new ArrayList<>();
            for (int j = 0; j < temp.length(); j++) {
                if (j < temp.length() - 1 && temp.charAt(j) == '1' && temp.charAt(j + 1) == '*') {
                    j = j + 1;
                } else if (j < temp.length() - 1 && temp.charAt(j) == '*' &&
                        temp.charAt(j + 1) == '1') {
                    j = j + 1;
                } else {
                    result.add(temp.charAt(j));
                }
            }
            String tempResult = "";
            for (char k : result) {
                String strChar = Character.toString(k);
                tempResult = tempResult + strChar;
            }
            char sign = input.get(i).getSign();
            input.set(i, new Item(sign, tempResult));
        }
        return input;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainSchedule {
    private HashMap<Integer, ArrayList<Item>> solution = new HashMap<>();
    private ArrayList<String> prepare = new ArrayList<>();
    private List<String> exprs = new ArrayList<>();

    public MainSchedule(List<String> exprs) {
        this.exprs = exprs;
        this.prepare = addPrepare(exprs);
    }

    private ArrayList<String> addPrepare(List<String> exprs) {
        prepare.addAll(exprs);
        return prepare;
    }

    private void schedule() {
        for (int i = 0; i < prepare.size(); i++) {
            String[] str = prepare.get(i).split(" ");
            ArrayList<Item> listA = new ArrayList<>();
            ArrayList<Item> listB = new ArrayList<>();
            if (str[1].equals("add")) {
                listA.addAll(inputList(str[2]));
                listB.addAll(inputList(str[3]));
                Add add = new Add(listA, listB);
                solution.put(i + 1, add.getResult());
            } else if (str[1].equals("pos")) {
                listA.addAll(inputList(str[2]));
                solution.put(i + 1, listA);
            } else if (str[1].equals("sub")) {
                listA.addAll(inputList(str[2]));
                if (str[3].charAt(0) == 'f') {
                    int num = Integer.parseInt(str[3].substring(1));
                    listB.addAll(solution.get(num));
                } else {
                    char sign;
                    String content;
                    if (str[3].charAt(0) == '-') {
                        sign = '+';
                        content = str[3].substring(1);
                    } else if (str[3].charAt(0) == '+') {
                        sign = '-';
                        content = str[3].substring(1);
                    } else {
                        sign = '-';
                        content = str[3];
                    }
                    Item item3 = new Item(sign, content);
                    listA.add(item3);
                }
                Sub sub = new Sub(listA, listB);
                solution.put(i + 1, sub.getResult());
            } else if (str[1].equals("neg")) {
                if (str[2].charAt(0) == 'f') {
                    int num = Integer.parseInt(str[2].substring(1));
                    ArrayList<Item> listTemp =
                            new ArrayList<>(solution.get(num));
                    for (Item m : listTemp) {
                        if (m.getSign() == '-') {
                            listA.add(new Item('+', m.getContent()));
                        } else {
                            listA.add(new Item('-', m.getContent()));
                        }
                    }
                } else {
                    char sign;
                    String content;
                    if (str[2].charAt(0) == '-') {
                        sign = '+';
                        content = str[2].substring(1);
                    } else if (str[2].charAt(0) == '+') {
                        sign = '-';
                        content = str[2].substring(1);
                    } else {
                        sign = '-';
                        content = str[2];
                    }
                    Item item = new Item(sign, content);
                    listA.add(item);
                }
                solution.put(i + 1, listA);
            } else if (str[1].equals("mul")) {
                listA.addAll(inputList(str[2]));
                listB.addAll(inputList(str[3]));
                Mul mul = new Mul(listA, listB);
                solution.put(i + 1, mul.getResult());
            } else if (str[1].equals("pow")) {
                listA.addAll(inputList(str[2]));
                int num = Integer.parseInt(str[3]);
                Pow pow = new Pow(listA, num);
                solution.put(i + 1, pow.getResult());
            } else if (str[1].equals("sin")) {
                listA.addAll(inputList(str[2]));
                Sin sin = new Sin(listA);
                solution.put(i + 1, sin.getResult());
            } else if (str[1].equals("cos")) {
                listA.addAll(inputList(str[2]));
                Cos cos = new Cos(listA);
                solution.put(i + 1, cos.getResult());
            } else if (str[1].equals("null")) {
                listA.addAll(inputList(str[2]));
                solution.put(i + 1, listA);
            } else {
                continue;
            }
        }
    }

    public ArrayList<Item> inputList(String str) {
        ArrayList<Item> list = new ArrayList<>();
        if (str.charAt(0) == 'f') {
            int num = Integer.parseInt(str.substring(1));
            list.addAll(solution.get(num));
        } else {
            char sign;
            String content;
            if (str.charAt(0) == '-') {
                sign = '-';
                content = str.substring(1);
            } else if (str.charAt(0) == '+') {
                sign = '+';
                content = str.substring(1);
            } else {
                sign = '+';
                content = str;
            }
            Item item2 = new Item(sign, content);
            list.add(item2);
        }
        return list;
    }

    public ArrayList<Item> getResult() {
        schedule();
        Simplify simplify = new Simplify(solution.get(solution.size()));
        return simplify.cal();
    }
}

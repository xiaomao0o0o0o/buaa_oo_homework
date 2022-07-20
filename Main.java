import com.oocourse.spec3.ExprInput;
import com.oocourse.spec3.ExprInputMode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExprInput scanner = new ExprInput(ExprInputMode.ParsedMode);

        // 预解析读入模式下，使用getCount()读入接下来还要读取多少行解析后的表达式
        int n = scanner.getCount();

        // 调用n次readLine()方法，读入解析后的表达式，并存储到容器exprs中
        List<String> exprs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String curExpr = scanner.readLine();
            exprs.add(curExpr);
        }
        MainSchedule mainSchedule = new MainSchedule(exprs);
        ArrayList<Item> result = new ArrayList<>(mainSchedule.getResult());
        if (result.get(0).getSign() == '+') {
            System.out.print(result.get(0).getContent());
        } else {
            System.out.print("-" + result.get(0).getContent());
        }
        for (int j = 1; j < result.size(); j++) {
            if (result.get(j).getSign() == '+') {
                System.out.print("+" + result.get(j).getContent());
            } else {
                System.out.print("-" + result.get(j).getContent());
            }
        }
    }
}

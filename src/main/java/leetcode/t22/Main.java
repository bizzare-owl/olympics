package leetcode.t22;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return List.of("");
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (String a : generateParenthesis(i)) {
                for (String b : generateParenthesis(n - i - 1)) {
                    result.add("(" + a + ")" + b);
                }
            }
        }
        return result;
    }

    static void main() {
        System.out.println(generateParenthesis(4));
    }

}

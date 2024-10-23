package Hw4_22000132_NguyenDuyVu.stack.Bai3;

import java.util.Stack;

public class IsValidateEpx {
    public static boolean isValiEpx(String epx) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < epx.length(); i++) {
            if (epx.charAt(i) == '(') {
                stack.push(epx.charAt(i));
            } else if (epx.charAt(i) == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String epx = "(5 − (8 − 4) ∗ (2 + 3)) + (8/4)";
        System.out.println(isValiEpx(epx));
    }
}

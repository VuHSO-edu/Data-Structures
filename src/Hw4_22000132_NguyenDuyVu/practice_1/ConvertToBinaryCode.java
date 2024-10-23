package Hw4_22000132_NguyenDuyVu.practice_1;

import java.util.Stack;

public class ConvertToBinaryCode {
    public static String convertToBinary(int n) {
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }
        String res = "";
        while (!stack.isEmpty()) {
            res += String.valueOf(stack.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println( convertToBinary(13));
    }
}

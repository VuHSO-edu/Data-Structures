package Hw4_22000132_NguyenDuyVu.stack;

import java.util.Stack;

public class Bai1 {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        String hoten = "NguyenDuyVu";
        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0) {
                s.push(hoten.charAt(i));
            }
            if (i % 3 == 0) {
                s.pop();
            }

        }
        System.out.println(s);

    }
}

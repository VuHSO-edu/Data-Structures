package Hw4_22000132_NguyenDuyVu.practice_4;

import java.util.Stack;

public class Main {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
           if (s.charAt(i) == ')') {
               if (stack.empty()) {
                   return false;
               }
               if (stack.peek() == '(') {
                   stack.pop();
               } else return false;
           }
           if (s.charAt(i) == '}') {
               if (stack.empty()) {
                   return false;
               }
               if (stack.peek() == '{') {
                   stack.pop();
               } else return false;
           }
           if (s.charAt(i) == ']') {
               if (stack.empty()) {
                   return false;
               }
               if (stack.peek() == '[') {
                   stack.pop();
               } else return false;
           }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(()"));
    }
}

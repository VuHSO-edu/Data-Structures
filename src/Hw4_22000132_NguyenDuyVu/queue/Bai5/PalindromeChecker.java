package Hw4_22000132_NguyenDuyVu.queue.Bai5;

import Hw4_22000132_NguyenDuyVu.queue.Bai4.LinkedQueue;

import java.util.Stack;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        LinkedQueue<Character> queue = new LinkedQueue<>();
        Stack<Character> stack = new Stack<>();

        // Đưa từng ký tự vào Queue và Stack
        for (char ch : str.toCharArray()) {
            queue.enqueue(ch);
            stack.push(ch);
        }

        // So sánh từng ký tự từ Queue và Stack
        while (!queue.isEmpty()) {
            if (queue.dequeue() != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("hello"));
    }
}

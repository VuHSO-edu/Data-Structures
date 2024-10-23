package Hw4_22000132_NguyenDuyVu.practice_1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class StringCompression {

    public static String compress(String str) {
        Queue<Character> queue = new ArrayDeque<>();
        Queue<Integer> countQueue = new ArrayDeque<>();
        int count = 1;
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (queue.isEmpty()) {
                queue.add(c);
            }
            if (str.charAt(i) != c ) {
                countQueue.add(count);
                queue.add(str.charAt(i));
                c = str.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        countQueue.add(count);
        String res = "";
        while (!queue.isEmpty()) {
            res += queue.poll();
            res += countQueue.poll();
        }
        return  res;
    }

    public static void main(String[] args) {
        String res = "aaabbaaac";
        System.out.println(compress(res));
    }
}

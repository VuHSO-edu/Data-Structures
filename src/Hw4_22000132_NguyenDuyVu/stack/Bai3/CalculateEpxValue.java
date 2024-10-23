package Hw4_22000132_NguyenDuyVu.stack.Bai3;

import java.util.Stack;

public class CalculateEpxValue {
    public static boolean isValidateEpx(String epx) {
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

    public static boolean isValidateNumber(String epx) {
        try {
            Integer.parseInt(epx);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidateSign(String epx) {
        return switch (epx) {
            case "−" -> true;
            case "+" -> true;
            case "∗" -> true;
            case "/" -> true;
            default -> false;
        };
    }

    public static double calculateEpx(String num1, String num2, String sign) {
        if (sign.equals("+")) {
            return Double.parseDouble(num1) + Double.parseDouble(num2);
        }
        if (sign.equals("−")) {
            if (Double.parseDouble(num1) < Double.parseDouble(num2) ) return Double.parseDouble(num2) - Double.parseDouble(num1);
            return Double.parseDouble(num1) - Double.parseDouble(num2);
        }
        if (sign.equals("∗")) {
            return Double.parseDouble(num1) * Double.parseDouble(num2);
        }
        if (sign.equals("/")) {
            if (Double.parseDouble(num1) < Double.parseDouble(num2)) return Double.parseDouble(num2) / Double.parseDouble(num1);
            return Double.parseDouble(num1) / Double.parseDouble(num2);
        }
        return 0;
    }

    public static double calcuEpxValue(String epx) {
        Stack<String> stackNumber = new Stack<>();
        Stack<String> stackSign = new Stack<>();
        if (isValidateEpx(epx)) {
            String[] temp = epx.split("");
            for (String s : temp) {
                if (isValidateNumber(s)) {
                    stackNumber.push(s);
                }
                if (isValidateSign(s)) {
                    stackSign.push(s);
                }
                if (s.equals(")")) {
                    String num1 = stackNumber.pop();
                    System.out.println(num1);
                    String num2 = stackNumber.pop();
                    System.out.println(num2);
                    String sign = stackSign.pop();
                    System.out.println(sign);
                    double calculateEpx = calculateEpx(num1, num2, sign);
                    System.out.println(calculateEpx);
                    stackNumber.push(String.valueOf(calculateEpx));
                }
            }
            return Double.parseDouble(stackNumber.peek());
        }
        return 0;
    }


    public static void main(String[] args) {
        String epx = "(5 − (8 − 4) ∗ (2 + 3)) + (8/4)";
        System.out.println(calcuEpxValue(epx));

    }
}

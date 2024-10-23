package Hw4_22000132_NguyenDuyVu.stack.Bai2;

public class Test {

    public static void main(String[] args) {
        StackInterface<Integer> stackInterface = new LinkedListStack<>();

        stackInterface.push(1);
        stackInterface.push(2);
        stackInterface.push(3);
        stackInterface.push(4);
        stackInterface.push(5);
        stackInterface.push(6);
        System.out.println(stackInterface.pop());
        System.out.println(stackInterface.pop());
        System.out.println(stackInterface.pop());
        System.out.println(stackInterface.top());
        System.out.println(stackInterface.pop());
        System.out.println(stackInterface.top());
        System.out.println(stackInterface.isEmpty());

    }
}

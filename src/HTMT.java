public class HTMT {

    public static void sum(byte a, byte b) {
        byte a1 = (byte) a;
        byte b1 = (byte) b;
        int c = a1 + b1;
        System.out.println(c);
    }

    public static void muti(byte a, byte b) {
        byte a1 = (byte) a;
        byte b1 = (byte) b;
        int c = a1 * b1;
        System.out.println(c);
    }

    public static void sunUnsign(int a , int b) {
        int a1 = a;
        int b1 = b;
        int c = (a1 + b1) % 256;
        System.out.println(c);
    }

    public static void mutiUnsign(int a , int b) {
        int a1 = a;
        int b1 = b;
        int c = (a1 * b1) % 256;
        System.out.println(c);
    }

    public static void maBu2(int number) {
        String binaryRepresentation = Integer.toBinaryString(number & 0xFF);
        binaryRepresentation = String.format("%8s", binaryRepresentation).replace(' ', '0');
        System.out.println(binaryRepresentation);

    }
    public static void chuyenDoiNhiPhanSang8Bit(String originalBits ) {
        String binaryRepresentation = originalBits;
        binaryRepresentation = String.format("%8s", binaryRepresentation).replace(' ', '0');
        System.out.println(binaryRepresentation);
    }

    public static void chuyenDoiMaNhiPhan(String number) {
        int decimal = Integer.parseInt(number, 2);
        System.out.println(decimal);
    }

    public static void chuyenDoiGiaTriDoi(String number) {
        int i = Integer.parseInt(number, 2);
        int negativeValue = -i;
        String positiveBits = Integer.toBinaryString(negativeValue & 0xFF);
        String paddedBits = String.format("%8s", positiveBits).replace(' ', '0');
        System.out.println("Chuỗi bit biểu diễn giá trị đối của -i: " + paddedBits);
    }

    public static void main(String[] args) {
        // tinh ma bu 2 cua so 55
        maBu2(-55);
    }
}

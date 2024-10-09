package Hw3_22000132_NguyenDuyVu;

import java.util.*;

public class FractionTest {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of fractions: ");
        int n = scan.nextInt();
        int v = scan.nextInt();
        ArrayList<Fraction> fractions = Arrays.stream(new Fraction[n]).map(i -> {
            Random random = new Random();
            return new Fraction(random.nextFloat(100), random.nextFloat(100));
        }).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println(fractions.toString());

        System.out.println(fractions.get(v-1));

        System.out.println("Sum of all fractions: ");
        Fraction sum = new Fraction(0, 1);
        for (Fraction f : fractions) {
            sum = sum.add(f);
            sum.normalize(sum);
        }
        System.out.println(sum);

        System.out.println("Minus of all fractions: ");
        Fraction minus = fractions.get(0);
        for (int i = 1; i < fractions.size(); i++) {
            minus = minus.minus(fractions.get(i));
            minus.normalize(minus);
        }
        System.out.println(minus);


        System.out.println("Multiplication of all fractions: ");
        Fraction multi = new Fraction(1, 1);
        for (Fraction f : fractions) {
            multi = multi.multi(f);
            multi.normalize(multi);
        }
        System.out.println(multi);

        System.out.println("Division of all fractions: ");
        Fraction divi = fractions.get(0);
        for (int i = 1; i < fractions.size(); i++) {
            divi = divi.divi(fractions.get(i));
            divi.normalize(divi);
        }
        System.out.println(divi);


    }
}

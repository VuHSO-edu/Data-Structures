package Hw2_22000132_NguyenDuyVu.Bai3;

import java.util.Arrays;
import java.util.Comparator;

public class CompareCard implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        if (o1.getRank() != o2.getRank()) {
            return Integer.compare(o1.getRank(), o2.getRank());
        } else {
            return o1.getSuit().compareTo(o2.getSuit());
        }
    }
}

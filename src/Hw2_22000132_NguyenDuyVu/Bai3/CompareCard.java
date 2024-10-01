package Hw2_22000132_NguyenDuyVu.Bai3;

import java.util.Arrays;
import java.util.Comparator;

public class CompareCard<T> implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return Integer.compare(o1.getRank(), o2.getRank());
    }
}

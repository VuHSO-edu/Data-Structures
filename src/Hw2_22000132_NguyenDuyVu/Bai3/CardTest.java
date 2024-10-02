package Hw2_22000132_NguyenDuyVu.Bai3;

import Hw2_22000132_NguyenDuyVu.Bai2;

import java.util.Arrays;

public class CardTest {
    public static Card[] createDeck(){
        Card[] cards = new Card[52];
        int index = 0;

        for (Suit suit : Suit.values()) {
            for (int rank = 2 ; rank <= 14 ; rank++){
                cards[index++] = new Card(suit, rank);
            }
        }

        System.out.println(Arrays.toString(cards));
        return cards;
    }

    public static void sortDeck(Card[] cards){
        CompareCard compareCard = new CompareCard();
//        Arrays.sort(cards, compareCard);
//        Bai2.bubbleSort(cards);
//        Bai2.mergeSort(cards, 0, cards.length - 1);
//        Bai2.selectionSort(cards);
//        Bai2.insertionSort(cards);
        Bai2.quickSort(cards, 0, cards.length - 1);
        System.out.println(Arrays.toString(cards));
    }

    public static void main(String[] args) {
        sortDeck(createDeck());
    }
}

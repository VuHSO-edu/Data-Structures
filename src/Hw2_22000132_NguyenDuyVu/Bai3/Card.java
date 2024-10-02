package Hw2_22000132_NguyenDuyVu.Bai3;

public class Card implements Comparable<Card> {
    private Suit suit;
    private int rank;

    public Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card o) {
       if (this.rank != o.rank) {
            return Integer.compare(this.rank, o.rank);
        } else {
            return this.suit.compareTo(o.suit);
        }
    }
}

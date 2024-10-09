package Hw3_22000132_NguyenDuyVu.listInterface;

import java.util.Objects;

public class WordCount {
    private String word;
    private int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increaseCount() {
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCount wordCount = (WordCount) o;
        return count == wordCount.count && Objects.equals(word, wordCount.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, count);
    }

    @Override
    public String toString() {
        return word + " " + count;
    }
}

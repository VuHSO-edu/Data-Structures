package Hw5_22000132_NguyenDuyVu.BaiTap1;

public interface PriorityQueueInterface<K,E> {
    int size();
    boolean isEmpty();
    Entry<K,E> insert(K key, E element) throws IllegalArgumentException;
    Entry<K,E> min();
    Entry<K,E> removeMin();
}

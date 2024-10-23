package Hw4_22000132_NguyenDuyVu.queue.Bai4;

public interface QueueInterface<E> extends Iterable<E> {
    void enqueue(E element);
    E dequeue();
    boolean isEmpty();
}

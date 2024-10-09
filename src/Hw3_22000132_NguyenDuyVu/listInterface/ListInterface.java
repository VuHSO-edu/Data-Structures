package Hw3_22000132_NguyenDuyVu.listInterface;

public interface ListInterface<T> extends Iterable<T> {
    public void add(T data);
    public T get(int index);
    public void set(int index, T data);
    public void remove(int index);
    public void isContain(T data);
    public int size();
    public boolean isEmpty();

}

package Hw9_22000132_NguyenDuyVu.BaiTap1_2_3;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n = 0;
    private int defaultSize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
    }

    @Override
    public T root() {
        return (T) array[0];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(T p) {
        int index = findIndex(p);
        if (index == -1) return 0;
        int count = 0;
        if (2 * index + 1 < defaultSize && array[2 * index + 1] != null) count++;
        if (2 * index + 2 < defaultSize && array[2 * index + 2] != null) count++;
        return count;
    }

    @Override
    public T parent(T p) {
        int index = findIndex(p);
        if (index <= 0) return null;
        return (T) array[(index - 1) / 2];
    }

    @Override
    public T left(T p) {
        int index = findIndex(p);
        if (index == -1 || 2 * index + 1 >= defaultSize) return null;
        return (T) array[2 * index + 1];
    }

    @Override
    public T right(T p) {
        int index = findIndex(p);
        if (index == -1 || 2 * index + 2 >= defaultSize) return null;
        return (T) array[2 * index + 2];
    }

    @Override
    public T sibling(T p) {
        int index = findIndex(p);
        if (index <= 0) return null;
        if (index % 2 == 1) return (T) array[index + 1];
        else return (T) array[index - 1];
    }

    public void setRoot(E element) {
        array[0] = element;
        n++;
    }

    public void setLeft(int p, E element) {
        if (array[p] == null) {
            System.out.println("Parent is null");
            return;
        }
        if (2 * p + 1 >= defaultSize) {
            System.out.println("Out of range");
            return;
        }
        array[2 * p + 1] = element;
        n++;
    }

    public void setRight(int p, E element) {
        if (array[p] == null) {
            System.out.println("Parent is null");
            return;
        }
        if (2 * p + 2 >= defaultSize) {
            System.out.println("Out of range");
            return;
        }
        array[2 * p + 2] = element;
        n++;
    }

    private int findIndex(T p) {
        for (int i = 0; i < defaultSize; i++) {
            if (array[i] != null && array[i].equals(p)) {
                return i;
            }
        }
        return -1;
    }
}
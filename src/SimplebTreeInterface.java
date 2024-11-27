public interface SimplebTreeInterface<Key extends Comparable<Key>> extends Iterable<Key> {
    void insert(Key key);
    Key search(Key key);
    int size();
    boolean isEmpty();
}

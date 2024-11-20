package Hw8_22000132_NguyenDuyVu.Bai1;

public abstract class AbstractSymbolTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {
    public boolean contains ( Key key ) {
         return get ( key ) != null ;
    }


    public void delete ( Key key ) {
        put ( key , null ) ;
    }


}

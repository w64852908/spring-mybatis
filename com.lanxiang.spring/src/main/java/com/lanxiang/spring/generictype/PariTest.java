package com.lanxiang.spring.generictype;

/**
 * Created by lanxiang on 2018/1/12.
 */
public class PariTest {


    private static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return true;
    }

}

class Pair<K, V> {

    private K key;

    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

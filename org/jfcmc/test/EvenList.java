package org.jfcmc.test;

import java.util.List;
import java.util.Iterator;

public class EvenList<E> {

    private List<E> list;

    public EvenList(List<E> list) {
        this.list = list;
    }

    public int size() {
        return list.size() / 2;
    }

    public E get(int index) {
        return list.get(index*2);
    }

    public Iterator<E> iterator() {
        EvenList<E> evenList = this;
        return new Iterator<>() {
            private int index = 0;
            public boolean hasNext() {
                return index < evenList.size();
            }
            public E next() {
                return evenList.get(index++);
            }

        };
    }
}

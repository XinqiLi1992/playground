package datastructures.list;

public interface List<E> {
    int getSize();
    boolean isEmpty();
    void add(int index, E e);
    void addFirst(E e);
    void addLast(E e);
    E remove(int index);
    E removeFirst();
    E removeLast();
    void removeElement(E e);
    void set(int index, E e);
    boolean contains(E e);
    E find(int index);
}

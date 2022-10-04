package model;

public class Item<T>{
    T element;

    public Item(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }
}

package DinamickArrayClass;

import java.util.*;
import java.util.function.Consumer;

public class DynamicArray<T> implements Iterable<T> {

    // ++ add(data), add(data...) - добавляет в конец
    // ++ remove() - удаляет последний
    // ++ removeAt(index) - удаляет по индексу
    // ++ growSize() - увеличивает размер
    // ++ setItem(index, data) - изменяет элемент
    // ++ clean() - удаляет все элементы
    // ++ contains(data) - проверяет существует ли элемент
    // ++ isEmpty() - вернет false, если в структуре есть элемент
    private Integer size;
    private T[] list;
    private static final int defaultCapacity = 10;
    private int freeCapacity = 0;

    public DynamicArray() {
        this.size = defaultCapacity;
        this.list = (T[]) new Object[defaultCapacity];

    }

    public DynamicArray(Integer size) {
        this.size = size;
        this.list = (T[]) new Object[size];
    }

    public void add(T data) {

        this.list[this.freeCapacity] = data;
        this.freeCapacity++;
        if (this.freeCapacity == this.size) {// проверка на заполнение
            this.growSize();
        }
    }

    public void add(T... dats) {
        for (T t : dats) {
            add(t);
        }
    }

    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("array is empty");
        }
        this.list[--this.freeCapacity] = null;
    }

    public void removeAt(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.list[i] = this.list[i + 1];

        }
        this.list[this.freeCapacity--] = null;
    }

    public void growSize() {
        int siz = this.size * 2;
        T[] newList = (T[]) new Object[siz];   // создаем новый массив с развером вдвое больше
        // создали новый массив и перемстили в него старые данные
        System.arraycopy(this.list, 0, newList, 0, list.length);
        this.size = siz;
        this.list = newList;
    }

    public void setItem(T data, int index) {
        if (this.freeCapacity <= index) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of range");
        }
        this.list[index] = data;
    }

    public void clean() {
        this.list = (T[]) new Object[this.size];
        this.freeCapacity = 0;
    }

    public boolean contains(T data) {
        return Arrays.asList(this.list).contains(data);
    }


    public boolean isEmpty() {
        return this.freeCapacity == 0;
    }


    public String toStr() {
        StringBuilder stringArray = new StringBuilder("[");
        for (int i = 0; i < this.size; i++) {
            if (this.list[i] == null) {
                if (this.freeCapacity > 0) {
                    stringArray.delete(stringArray.length() - 2, stringArray.length());
                }
                break;
            }
            stringArray.append(this.list[i]);
            if (i < this.size - 1) {
                stringArray.append(", ");
            }
        }
        stringArray.append("]");
        return stringArray.toString();
    }

    // для возможности работы итератором
    @Override
    public Iterator<T> iterator() {
        return new DynamicListIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        System.out.println(action);
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }


    private class DynamicListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < freeCapacity;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return list[currentIndex++];
        }
    }

}

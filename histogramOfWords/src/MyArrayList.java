import java.util.Arrays;

public class MyArrayList<E> {
    Object[] array;
    public MyArrayList() {
        this.array = new Object[1024];
    }
    public MyArrayList(int size) {
        this.array = new Object[size];
    }
    public E get(int index) {
        return (E)array[index];
    }
    public void set(int index, E element) {
        array[index] = element;
    }
    public int size() {
        return firstFreeIndex;
    }
    int firstFreeIndex = 0;
    public void add(E element) {
        if (firstFreeIndex >= array.length) {
            Object[] tmp = Arrays.copyOf(array, 2*array.length);
            if(tmp != null) array = tmp;
        }
    }
}

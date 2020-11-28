import java.util.Iterator;

/**
 * @author Xrafece
 */
public class LIFO<T> implements Iterable<T>{

    private T[] t = (T[]) new Object[1];
    private int n = 0;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public T pop() {
        T t = t[--n];
        t[n] = null;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

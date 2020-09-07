package Exercise.iterator;

import java.util.*;

/**
 * Exercise.iterator
 *
 * @author plusman
 * @since 2020/9/6
 */
public class SnapshotArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 255;

    transient Object[] elementData;
    transient Long[] addTimestamp;
    transient Long[] delTimestamp;

    private int size = 0;
    private int actualSize = 0;

    public static void main(String[] args) {
        SnapshotArrayList<String> list = new SnapshotArrayList<>();
        list.add("A");
        list.add("B");

        Iterator<String> iterator1 = list.iterator();
        System.out.println(iterator1.next());

        System.out.println("list 内新增元素 C");
        list.add("C");

        System.out.println("打印 iterator1 剩余元素");
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        list.remove("B");

        Iterator<String> iterator2 = list.iterator();
        System.out.println("打印 iterator2 所有元素");
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }

        System.out.println("当前数组尺寸：" + list.size());
    }

    public SnapshotArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.addTimestamp = new Long[DEFAULT_CAPACITY];
        this.delTimestamp = new Long[DEFAULT_CAPACITY];
    }

    private class Itr implements Iterator<E> {
        private int[] snapShotIndex;
        private Long snapshotTime = System.currentTimeMillis();
        private int itrSize = 0;
        private int cursor = -1;

        public Itr() {
            snapShotIndex = new int[SnapshotArrayList.this.size()];
            for(int index = 0; index < SnapshotArrayList.this.actualSize; index++) {
                if ( snapshotTime >= addTimestamp[index] && snapshotTime < delTimestamp[index]) {
                    snapShotIndex[itrSize++] = index;
                }
            }
        }

        @Override
        public boolean hasNext() {
            if(cursor + 1 != itrSize) {
                return true;
            }

            return false;
        }

        @Override
        public E next() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }

            return (E) elementData[snapShotIndex[++cursor]];
        }
    }

    @Override
    public boolean add(E e) {
        // 达到容量上限则添加失败
        if(actualSize + 1 == elementData.length) {
            return false;
        }

        int cursor = actualSize++;
        elementData[cursor] = e;
        addTimestamp[cursor] = System.currentTimeMillis();
        delTimestamp[cursor] = Long.MAX_VALUE;

        // 当前有效元素
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }

        return false;
    }

    private void fastRemove(int index) {
        delTimestamp[index] = System.currentTimeMillis();
        size--;
    }

    @Override
    public int size() {
        // size
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}

package com.rrow.study.安全集合;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: Rrow
 * @date: 2023/8/28 0:33
 * Description:
 */
public class No0001安全集合类 {
    @Test
    public void CollectionsSynchronizedList01() {
        ArrayList<String> list = new ArrayList<>();
        // 线程不安全的集合转换成线程安全的集合
        /*
        * public void add(int index, E element) {
            synchronized (mutex) {list.add(index, element);}
        }
        * */
        List<String> synchronizedList = Collections.synchronizedList(list);
    }
    @Test
    public void Vector02() {
        // 线程安全的集合
        /**
         * public synchronized boolean add(E e) {
         *         modCount++;
         *         ensureCapacityHelper(elementCount + 1);
         *         elementData[elementCount++] = e;
         *         return true;
         *     }
         */
        Vector<String> vector = new Vector<>();
    }
    @Test
    public void CopyOnWriteArrayList03() {
        // 线程安全的集合
        /**
         * final transient ReentrantLock lock = new ReentrantLock();
         *  public boolean add(E e) {
         *         final ReentrantLock lock = this.lock;
         *         lock.lock();
         *         try {
         *             Object[] elements = getArray();
         *             int len = elements.length;
         *             // 这里创建了一个新的数组
         *             Object[] newElements = Arrays.copyOf(elements, len + 1);
         *             newElements[len] = e;
         *             // 将新数据放进去,读老的数据,达到读写分离的效果
         *             setArray(newElements);
         *             return true;
         *         } finally {
         *             lock.unlock();
         *         }
         *     }
         */
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    }
    @Test
    public void CopyOnWriteArraySet04() {
        /*
        public boolean add(E e) {
        return al.addIfAbsent(e);
        }
        *
        public boolean addIfAbsent(E e) {
        Object[] snapshot = getArray();
        return indexOf(e, snapshot, 0, snapshot.length) >= 0 ? false :
        addIfAbsent(e, snapshot);
        }
        *
        // 这里还是用的ReentrantLock来做一个上锁
        private boolean addIfAbsent(E e, Object[] snapshot) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            Object[] current = getArray();
            int len = current.length;
            if (snapshot != current) {
                // Optimize for lost race to another addXXX operation
                int common = Math.min(snapshot.length, len);
                for (int i = 0; i < common; i++)
                    if (current[i] != snapshot[i] && eq(e, current[i]))
                        return false;
                if (indexOf(e, current, common, len) >= 0)
                        return false;
            }
            Object[] newElements = Arrays.copyOf(current, len + 1);
            newElements[len] = e;
            setArray(newElements);
            return true;
        } finally {
            lock.unlock();
        }
    }
        * */
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
    }

    @Test
    public void ConcurrentHashMap05() {
        /**
         * final V putVal(K key, V value, boolean onlyIfAbsent) {
         *         if (key == null || value == null) throw new NullPointerException();
         *         int hash = spread(key.hashCode());
         *         int binCount = 0;
         *         for (Node<K,V>[] tab = table;;) {
         *             Node<K,V> f; int n, i, fh;
         *             if (tab == null || (n = tab.length) == 0)
         *                 tab = initTable();
         *             else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
         *                 if (casTabAt(tab, i, null,
         *                              new Node<K,V>(hash, key, value, null)))
         *                     break;                   // no lock when adding to empty bin
         *             }
         *             else if ((fh = f.hash) == MOVED)
         *                 tab = helpTransfer(tab, f);
         *             else {
         *                 V oldVal = null;
         // *                 synchronized (f) {
         // *                     if (tabAt(tab, i) == f) {
         // *                         if (fh >= 0) {
         // *                             binCount = 1;
         // *                             for (Node<K,V> e = f;; ++binCount) {
         // *                                 K ek;
         // *                                 if (e.hash == hash &&
         // *                                     ((ek = e.key) == key ||
         // *                                      (ek != null && key.equals(ek)))) {
         // *                                     oldVal = e.val;
         // *                                     if (!onlyIfAbsent)
         // *                                         e.val = value;
         // *                                     break;
         // *                                 }
         // *                                 Node<K,V> pred = e;
         // *                                 if ((e = e.next) == null) {
         // *                                     pred.next = new Node<K,V>(hash, key,
         // *                                                               value, null);
         // *                                     break;
         // *                                 }
         // *                             }
         // *                         }
         // *                         else if (f instanceof TreeBin) {
         // *                             Node<K,V> p;
         // *                             binCount = 2;
         // *                             if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
         // *                                                            value)) != null) {
         // *                                 oldVal = p.val;
         // *                                 if (!onlyIfAbsent)
         // *                                     p.val = value;
         // *                             }
         // *                         }
         // *                     }
         // *                 }
         *                 if (binCount != 0) {
         *                     if (binCount >= TREEIFY_THRESHOLD)
         *                         treeifyBin(tab, i);
         *                     if (oldVal != null)
         *                         return oldVal;
         *                     break;
         *                 }
         *             }
         *         }
         *         addCount(1L, binCount);
         *         return null;
         *     }
         */
        // jdk1.8本质还是加了一个synchronize作为锁,1.7是分段锁(segment)
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
    }
}

package lurcache;

import java.util.*;

class LRUCacheKeyValue {
    int capacity;

    //LinkedListNode holds key and value pairs
    Set<Integer> cache;
    LinkedList<LinkedListNode> cache_vals;

    public LRUCacheKeyValue(int capacity) {
        this.capacity = capacity;
        cache = new HashSet<>(capacity);
        cache_vals = new LinkedList<>();
    }

    LinkedListNode get(int key) {
        if (!cache.contains(key)) {

            return null;
        } else {

            ListIterator<LinkedListNode> iterator1 = cache_vals.listIterator(0);
            while (iterator1.hasNext()) {
                LinkedListNode node = iterator1.next();
                if (node.key == key) {
                    return node;
                }
            }
            return null;
        }
    }

    void set(int key, int value) {
        LinkedListNode node = get(key);

        if (node == null) {
            evict_if_needed();
            node = new LinkedListNode(key, value);
            cache_vals.addLast(node);
            cache.add(key);
        } else {
            cache_vals.remove(node);
            cache_vals.addLast(node);
        }
    }

    void evict_if_needed() {
        if (cache_vals.size() >= capacity) {
            LinkedListNode node = cache_vals.remove();
            cache.remove(node.key);

        }
    }

    void print() {
        ListIterator<LinkedListNode> iterator = cache_vals.listIterator(0);
        while (iterator.hasNext()) {
            LinkedListNode node = iterator.next();
            System.out.print(node.key + ":" + node.value + ", ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LRUCacheKeyValue cache = new LRUCacheKeyValue(4);

        cache.set(10, 50);
        cache.print();

        cache.set(15, 25);
        cache.print();

        cache.set(20, 30);
        cache.print();

        cache.set(25, 35);
        cache.print();

        cache.set(20, 30);
        cache.print();

        cache.set(40, 50);
        cache.print();

        cache.set(25, 35);
        cache.print();
    }
}

class LinkedListNode {
    int key;
    int value;
    LinkedListNode pre;
    LinkedListNode next;

    public LinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
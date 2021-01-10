package lurcache;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class LRUCacheWithHashMap {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    LRUCacheWithHashMap(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            moveToFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
            return;
        }

        Node node = new Node(key, value);

        if (cache.size() == capacity) {
            cache.remove(tail.key);
            removeNode(tail);
        }

        cache.put(key, node);
        addFirst(node);
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addFirst(node);
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            head = nextNode;
        }

        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            tail = prevNode;
        }
    }

    private void addFirst(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = node;
        }
    }

    void print() {

        Node dummy = this.head;

        while (dummy != null) {
            System.out.print(dummy.key + ":" + dummy.value + ", ");
            dummy=dummy.next;
        }
        System.out.println("");

    }
}

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

public class LRUCacheTest {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int capacity = keyboard.nextInt();
        LRUCacheWithHashMap cache = new LRUCacheWithHashMap(capacity);

        while (true) {
            String[] commandLine = keyboard.nextLine().trim().split("\\s");
            String command = commandLine[0];
            if (command.isEmpty()) {
                continue;
            }
            switch (command) {
                case "get": {
                    int num = Integer.parseInt(commandLine[1]);
                    System.out.println(cache.get(num));
                    cache.print();

                    break;
                }
                case "put": {
                    int key = Integer.parseInt(commandLine[1]);
                    int value = Integer.parseInt(commandLine[2]);
                    cache.put(key, value);
                    cache.print();
                    break;
                }
                case "exit": {
                    return;
                }
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}

package basic.designhashset;

import java.util.BitSet;

/**
 * @author liuzhengyang
 */
public class DesignHashSet {
    public static void main(String[] args) {

    }

    /**
     * Node数组，Node是一个列表。头插法
     * 不考虑扩容了
     * 后来看了下题目限制，原来0<=key<=10000000，可以用bitmap或数组来实现
     */
    class MyHashSet {

        private static final int TABLE_SIZE = 1000;
        private Node[] table;

        class Node {
            private int value;
            private Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            this.table = new Node[TABLE_SIZE];
        }

        public void add(int key) {
            if (!contains(key)) {
                Node oldHead = table[hash(key)];
                Node newHead = new Node(key);
                newHead.next = oldHead;
                table[hash(key)] = newHead;
            }
        }

        public void remove(int key) {
            Node prev = null;
            int hash = hash(key);
            Node current = table[hash];
            if (current == null) {
                return;
            }
            while (current != null) {
                if (current.value == key) {
                    // remove
                    if (prev != null) {
                        prev.next = current.next;
                    } else {
                        table[hash] = current.next;
                    }
                }
                prev = current;
                current = current.next;
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            final int tableIndex = hash(key);
            Node node = table[tableIndex];
            if (node == null) {
                return false;
            }
            while (node != null) {
                if (node.value == key) {
                    return true;
                }
                node = node.next;
            }
            return false;
        }

        private int hash(int key) {
            return Math.abs(key % TABLE_SIZE);
        }
    }

    class MyHashSetV2 {
        // 用bitset，或这里实现一个bitset？


        private long[] bits;

        /**
         * Initialize your data structure here.
         */
        public MyHashSetV2() {
            bits = new long[10000000 / 64 + 1];
        }

        public void add(int key) {
            final int bitLongIndex = findBitLongIndex(key);
            int bitIndex = key % 64;
            bits[bitLongIndex] |= 1L << bitIndex;
        }

        public void remove(int key) {
            final int bitLongIndex = findBitLongIndex(key);
            int bitIndex = key % 64;
            bits[bitLongIndex] &= ~(1L << bitIndex);
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            final int bitLongIndex = findBitLongIndex(key);
            int bitIndex = key % 64;
            final long l = bits[bitLongIndex] & (1L << bitIndex);
            return l != 0;
        }

        private int findBitLongIndex(int key) {
            return key / 64;
        }
    }

}

package datastructures.linkedlist;

public class MyLinkedList {

    // `transient` keyword telling the compiler to not serialize these attributes...
    transient int size;
    transient Node head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(0, null);
    }

    // query operation search
    // time complexity O(n)
    /**
     * @return null if does not exist otherwise Node object is returned with specific key
     */
    Node search(int key) {
        Node node = this.head;

        while (node != null && node.item != key) {
            node = node.next;
        }
        return node;
    }

    // modification operation insert
    // time complexity is O(1)
    void insert(Node node) {
        node.next = this.head;
        if (this.head != null) {
            this.head.prev = node;
        }
        this.head = node;
        node.prev = null;
    }

    // modification operation delete
    // time complexity is O(1) in worst case O(n)
    void deleteNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.prev;
        } else {
            this.head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }


    private static class Node {

        int item;
        private Node prev;
        private Node next;

        public Node(int item, Node prev) {
            this.item = item;
            this.prev = prev;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                "item=" + item + "}";
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        Node tempPointer = this.head;

        while (tempPointer != null) {
            out
                .append(tempPointer.prev)
                .append( " <-- [")
                .append(tempPointer.item)
                .append("] --> ")
                .append(tempPointer.next);
            tempPointer = tempPointer.next;
        }
        return out.toString();
    }
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        System.out.println(myLinkedList);

        Node node1 = new Node(5, new Node(0, null));
        Node node2 = new Node(10, node1);
        Node node3 = new Node(15, node2);

        myLinkedList.insert(node1);
        myLinkedList.insert(node2);
        myLinkedList.insert(node3);

        System.out.println(myLinkedList);

        System.out.println(myLinkedList.search(15));
        System.out.println(myLinkedList.search(55));

        myLinkedList.deleteNode(node3);

        System.out.println(myLinkedList);

        myLinkedList.deleteNode(node2);

        System.out.println(myLinkedList);

    }
}

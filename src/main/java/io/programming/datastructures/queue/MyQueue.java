package io.programming.datastructures.queue;

import java.util.Arrays;

/**
 * Dynamic set implementation of the Queue using classic arrays and manipulate with int data type
 */
public class MyQueue {

    // queue pointers
    private int head;
    private int tail;

    private final int[] data;

    public MyQueue(int initialSize) {
        this.head = 0;
        this.tail = 0;
        this.data = new int[initialSize];
    }

    // insert operation
    void enqueue(int e) {
        if (isFull()) {
            throw new RuntimeException("Overflow the Queue is full!");
        } else {
            this.data[this.tail] = e;

            // condition to make queue circular...
            if (this.tail == this.data.length - 1) {
                this.tail = 0;
            } else {
                this.tail += 1;
            }
        }
    }

    // delete operation
    int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow there is no element in Queue!");
        } else {
            int e = this.data[this.head];

            // condition to make queue circular...
            if (this.head == this.data.length - 1) {
                this.head = 0;
            } else {
                this.head += 1;
            }
            return e;
        }
    }

    boolean isEmpty() {
        return this.head == this.tail;
    }

    boolean isFull() {
        return this.head == this.tail + 1;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
            "head=" + head +
            ", tail=" + tail +
            ", data=" + Arrays.toString(data) +
            '}';
    }
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);

        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(140);
        myQueue.enqueue(10);
        System.out.println(myQueue);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue);
        myQueue.enqueue(15);
        System.out.println(myQueue);
        // this will override start (because it's circular...)
        myQueue.enqueue(1000);
        System.out.println(myQueue);
    }

}

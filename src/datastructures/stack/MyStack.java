package datastructures.stack;

import java.util.Arrays;

/**
 * Dynamic set implementation of the Stack using classic arrays and manipulate with int data type
 */
public class MyStack {

    // pointer to the top of the stack
    int top;
    // data where we are gonna store
    int[] data;

    public MyStack(int howLarge) {
        // initialize stack to be empty
        this.top = -1;
        this.data = new int[howLarge];
    }

    // insert operation
    // time complexity - O(1)
    void push(int key) {
        this.top += 1;
        this.data[top] = key;
    }

    // delete operation
    // time complexity - O(1)
    int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow error");
        } else {
            this.top -= 1;
            return this.data[this.top + 1];
        }
    }

    // emptiness operation
    // time complexity - O(1)
    boolean isEmpty() {
        return this.top == -1;
    }

    @Override
    public String toString() {
        return "MyStack{" +
            "top=" + top +
            ", data=" + Arrays.toString(data) +
            '}';
    }
    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);

        System.out.println(myStack.isEmpty());
        System.out.println(myStack);
        myStack.push(10);
        myStack.push(20);
        System.out.println(myStack);
        System.out.println(myStack.pop());
        System.out.println(myStack);
        System.out.println(myStack.pop());
        System.out.println(myStack);
        myStack.push(15);
        System.out.println(myStack);
    }
}

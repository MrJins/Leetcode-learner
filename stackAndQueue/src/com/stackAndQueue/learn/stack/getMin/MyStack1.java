package com.stackAndQueue.learn.stack.getMin;

import java.util.Stack;

/**
 * 第一种方案
 */
public class MyStack1 {

    private Stack<Integer> stackData;

    private Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public Integer pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("stack is empty.");
        }
        Integer value = stackData.pop();
        if (value == this.getMin()) {
            stackMin.pop();
        }
        return value;
    }

    public void push(Integer value) {
        if (stackData.isEmpty()) {
            stackMin.push(value);
        } else if (value <= this.getMin()) {
            stackMin.push(value);
        }
        stackData.push(value);
    }

    public Integer getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty.");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        myStack1.push(2);
        myStack1.push(5);
        myStack1.push(1);
        myStack1.push(7);
        myStack1.push(9);

        System.out.println(myStack1.getMin());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.getMin());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.pop());
        System.out.println(myStack1.getMin());
    }
}

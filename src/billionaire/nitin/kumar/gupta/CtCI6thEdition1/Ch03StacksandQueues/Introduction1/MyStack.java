package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch03StacksandQueues.Introduction1;

import java.util.EmptyStackException;

public class MyStack<T> {
    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.getData();
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }
}

// ======= DO NOT EDIT THIS FILE ============

import java.util.*;

class MyQueue {

    LinkedList<Node> t;

    MyQueue() {
        t = new LinkedList<Node>();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void enqueue(Node p) {
        t.addLast(p);
    }

    Node dequeue() {
        if (isEmpty()) {
            return (null);
        }
        return (t.removeFirst());
    }

    Node front() {
        if (isEmpty()) {
            return (null);
        }
        return (t.getFirst());
    }
}
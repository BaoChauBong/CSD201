// ======= DO NOT EDIT THIS FILE ============

public class Node {

    Dog info;
    Node next;

    Node(Dog x, Node p) {
        info = x;
        next = p;
    }

    Node(Dog x) {
        this(x, null);
    }
}

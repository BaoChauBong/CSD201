/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Bảo Châu
 */
public class Node {
    Person data;
    Node next;

    public Node() {
    }

    public Node(Person data, Node next) {
        this.data = data;
        this.next = next;
    }
    
    public Node(Person data) {
        this.data = data;
        this.next = null;
    }
}

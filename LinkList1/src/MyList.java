/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Bảo Châu
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = tail = null;
    }

    public boolean isEmpty() {
//        if (head == null) {
//            return true;
//        } else {
//            return false;
//        }

        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void visit (Node p){
        if (p != null){
            System.out.println(p.data);
        }
    }
    
    public void traverse(){
        Node p = head;
        while (p != null){
            visit(p);
            p = p.next;
        }
        System.out.println();
    }
    
    public void addLast (Person x){
        Node p = new Node(x);
        if (isEmpty()){
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }
    
    public void addFirst (Person x){
        Node p = new Node(x);
        if (isEmpty()){
            head = tail = p;
            return;
        }
        p.next = head;
        head = p;
    }
    
    public Node searchByName (String xName){
        Node f = head;
        while (f != null){
            if (f.data.name.equals(xName)){
                return f;
            }
        }
        return null;
    }
    
    void addMany (String []a, int []b){
        for (int i = 0; i < a.length; i++) {
            addLast(new Person(a[i], b[i]));
        }
    }
    
}

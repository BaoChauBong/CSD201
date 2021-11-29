
  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import Entity.Book;

/**
 *
 * @author Kien
 */
public class Book_List {
    public Book_Node head, tail;

    public Book_List() {
        head = tail = null;
    }
    
    public boolean isEmpty() {
        return (head == null);
    }
    
    public int size() {
        int count = 0;
        Book_Node p = head;
        while(p != null){
            count ++;
            p = p.next;
        }
        return count;
    }
    
    public void addLast(Book x) {
        Book_Node q = new Book_Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }
    
    public void addFirst(Book x) {
        head = new Book_Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }
    
    public void visit(Book_Node p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }
    
    public void traverse() {
        Book_Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
    }
    
    public Book get(int i){
        int count = 0;
        for (Book_Node temp = head; temp != null; temp = temp.next) {
            if (count == i) {
                return temp.info;
            }
            count++;
        }
        return (null);
    }
    
    //delete at position k
	public void deleteAt(int k) {
        if (isEmpty()) return;
        if (k == 0) {//check if node is head
            Book_Node p = head;
            head = head.next;
            p.next = null;
        } else {	
            Book_Node p = pos(k);//get node position k
            if (p == null) return;
            Book_Node q = pos(k - 1);//q is node before of p
            // Remove p
            q.next = p.next;
            p.next = null;
            if (p == tail) tail = q;
        }
    }
        
    public void sortByBCode() {
        Book_Node pi, pj;
        Book x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.getBcode().compareTo(pi.info.getBcode()) < 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
 
    public Book_Node pos(int k) {
        int count = 0;
        for (Book_Node temp = head; temp != null; temp = temp.next) {
            if (count == k) {
                return temp;
            }
            count++;
        }
        return (null);
    }
    
    public void insertBefore(int k, Book x) {
        Book_Node p = new Book_Node(x);
        Book_Node q = pos(k);
        Book_Node temp = head;
        if (isEmpty()) {
            head = tail = p;
        } else {
            while (temp != null && temp.next != q) {
                temp = temp.next;
            };
            temp.next = p;
            p.next = q;
        }
    }
    
    public void sortByQuantity() {
        Book_Node pi, pj;
        Book x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.getQuantity() < pi.info.getQuantity()) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
}

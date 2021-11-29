/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import Entity.Book;

/**
 *
 * @author Bảo Châu
 */
public class Book_Node {
    Book info;
    Book_Node next;

    public Book_Node(Book x, Book_Node p) {
        info = x;
        next = p;
    }
    
    public Book_Node(Book x){
        this(x,null);
    }
    
}
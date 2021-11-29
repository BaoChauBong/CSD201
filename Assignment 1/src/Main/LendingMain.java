/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Bảo Châu
 */
import Constaint.Constaint;
import Entity.Book;
import Entity.Lending;
import Entity.LinkedList;
import Entity.Node;
import Entity.Reader;
import Entity.Validate;

public class LendingMain {

    private static LinkedList<Reader> readerList;
    private static LinkedList<Book> bookList;
    private static LinkedList<Lending> lendingList;

    public LendingMain(LinkedList<Reader> readerList, LinkedList<Book> bookList, LinkedList<Lending> lendingList) {
        this.readerList = readerList;
        this.bookList = bookList;
        this.lendingList = lendingList;
    }

    public static void menu() {
        System.out.println("********* Process lending list *********\n");
        System.out.println("1.Input data");
        System.out.println("2.Display data");
        System.out.println("3.Sort by bcode and rcode");
        System.out.println("4.Display book\n");
    }

    public void run() {

        int choice = 0;
        Node<Lending> p;
        Node<Book> b;
        do {
            menu();
            choice = Validate.checkInputIntLimit(1, 4, "Enter your choice: ");
            switch (choice) {
                case 1:
                    Validate.getLending(readerList, bookList, lendingList);
                    break;
                case 2:
                    lendingList.traverse();
                    break;
                case 3:
                    lendingList.sortLending();
                    break;
                case 4:
                    bookList.traverse();
                    break;
            }
        } while (choice != 4);

    }

}

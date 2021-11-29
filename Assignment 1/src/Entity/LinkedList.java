/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

/**
 *
 * @author Bảo Châu
 */
public class LinkedList<T> {

    public Node<T> head, tail;

    public LinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    public void addLast(T info) {
        Node p = new Node(info);
        if (isEmpty()) {
            head = tail = p;
            return;
        }
        tail.next = p;
        tail = p;
    }

    public void addAfter(int pos, T info) {
        Node p = new Node(info);
        Node f = getNode(pos);
        if (f == null) {
            return;
        }
        if (f == tail) {
            f.next = p;
            tail = p;
        } else {
            Node pNext = f.next;
            f.next = p;
            p.next = pNext;
        }
    }

    public Node getNode(int pos) {
        int length = 0;
        Node<T> p = head;
        while (p != null) {
            if (length == pos) {
                return p;
            }
            p = p.next;
            length++;
        }
        return null;
    }

    public void addFirst(T info) {
        Node p = new Node(info);
        p.next = head;
        head = p;
    }

    public void swap(Node pi, Node pj) {
        T info = (T) pj.info;
        pj.info = pi.info;
        pi.info = info;
    }

    // READER, BOOK LIST
    public void sort() {
        Node<T> pi, pj;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info instanceof Book) {
                    Book b1 = (Book) pi.info;
                    Book b2 = (Book) pj.info;
                    if (b1.getBcode().compareTo(b2.getBcode()) < 0) {
                        swap(pi, pj);
                    }
                } else {
                    Reader r1 = (Reader) pi.info;
                    Reader r2 = (Reader) pj.info;
                    if (r1.getRcode().compareTo(r2.getRcode()) < 0) {
                        swap(pi, pj);
                    }
                }
                pj = pi.next;
            }
            pi = pi.next;
        }
    }

    public void sort1() {
        Node<T> pi, pj;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                Book b1 = (Book) pi.info;
                Book b2 = (Book) pj.info;
                if (b1.getQuantity() > b2.getQuantity()) {
                    swap(pi, pj);
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    public void sortLending() {
        Node<T> pi, pj;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info instanceof Lending) {
                    Lending l1 = (Lending) pi.info;
                    Lending l2 = (Lending) pj.info;
                    if (l1.getBcode().compareTo(l2.getBcode()) < 0) {
                        swap(pi, pj);

                    } else if (l1.getBcode().compareTo(l2.getBcode()) == 0
                            && l1.getRcode().compareTo(l2.getRcode()) < 0) {
                        swap(pi, pj);
                    }
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }

    public void addMany(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            addLast(arr[i]);
        }
    }

    public int delete(Node q) {
        if (q == null || isEmpty()) {
            return Constaint.Constaint.SEARCH_FAIL;
        }
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return Constaint.Constaint.SEARCH_FAIL;
        }
        if (f == null)//q=head 
        {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return Constaint.Constaint.SEARCH_FAIL;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
        return Constaint.Constaint.SEARCH_SUCCESS;
    }

    public Node<T> searchByCode(String code) {
        Node<T> pi = head;
        while (pi != null) {
            T value = pi.info;
            if ((value instanceof Book && ((Book) pi.info).getBcode().trim().equalsIgnoreCase(code.trim()))
                    || (value instanceof Reader && ((Reader) pi.info).getRcode().trim().equalsIgnoreCase(code.trim()))) {
                return pi;
            }
            pi = pi.next;
        }
        return null;
    }

    public Node<T> searchBy2Code(String bcode, String rcode) {
        Node<T> p = head;
        while (p != null) {
            T value = p.info;
            if (value instanceof Lending) {
                Lending lending = (Lending) value;
                if (lending.getBcode().equalsIgnoreCase(bcode) && lending.getRcode().equalsIgnoreCase(rcode)) {
                    return p;
                }
            }
            p = p.next;
        }
        return null;
    }

    public int getLength() {
        int len = 0;
        Node<T> p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        return len;
    }

    public int deleteByCode(String code) {
        Node<T> p = searchByCode(code);
        return delete(p);
    }

    public void visit(Node p) {
        System.out.println(p.info.toString() + "  ");
    }

    public void traverse() {

        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
    }

    public void loadFromFile(String fname, int type) throws Exception {
        RandomAccessFile f = new RandomAccessFile(fname, "r");

        StringTokenizer t;
        String s, s1, s2;
        int k;
        clear();
        while (true) {
            s = f.readLine();
            if (s == null) {
                break;
            }
            if (s.trim().length() < 5) {
                continue;
            }
            t = new StringTokenizer(s, "|");

//B01 | Morning | 12 | 0 | 0.0
//5 token : B01, Moring, 12, 0 , 0.0
            if (type == Constaint.Constaint.INPUT_BOOK) {
                String bcode = t.nextToken().trim();
                String title = t.nextToken().trim();
                int quantity = Integer.parseInt(t.nextToken().trim());
                int lended = Integer.parseInt(t.nextToken().trim());
                double price = Double.parseDouble(t.nextToken().trim());
                Book book = new Book(bcode, title, quantity, lended, price);
                addLast((T) book);

            } else {
                String rcode = t.nextToken();
                String name = t.nextToken();
                int byear = Integer.parseInt(t.nextToken().trim());
                Reader reader = new Reader(rcode, name, byear);
                addLast((T) reader);
            }
        }
        f.close();
    }

    public void saveToFile(String fname) throws Exception {
        File f = new File(fname);
        if (f.exists()) {
            f.delete();
        }
        RandomAccessFile g = new RandomAccessFile(fname, "rw");
        Node p = head;
        while (p != null) {
            g.writeBytes(p.info.toString() + "\n");
            p = p.next;
        }
        g.close();
    }

    public static void main(String[] args) throws Exception {
        LinkedList<Book> bookList = new LinkedList();
        LinkedList<Reader> readerList = new LinkedList();
        bookList.loadFromFile("book.txt", Constaint.Constaint.INPUT_BOOK);
        bookList.traverse();
    }
}

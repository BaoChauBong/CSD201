/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//==================================================================
    void addLast(String xOwner, int xColor, int xPrice) {//You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'A') {
            return;
        } else {
            Dog x = new Dog(xOwner, xColor, xPrice);
            Node temp = new Node(x);
            if (isEmpty()) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }
    }

    void addFirst(Dog x) {

        Node q = new Node(x);

        Node temp = new Node(x, head);
        head = temp;
        if (tail == null) {
            tail = temp.next;
        }
    }

    void addLast(Dog x) {
        Node temp = new Node(x);
        if (isEmpty()) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    public int countElement() {

        int count = 0;

        Node temp = head;
        while (temp != null) {

            count++;
            temp = temp.next;
        }

        return count;
    }

    void dele(Node q) {
        if (q == null || isEmpty()) {
            return;
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
            return;
        }
        if (f == null)//q=head 
        {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }

    public void sortByPrice() {
        int count = 0;
        Node pi, pj;
        Dog t;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            if (count <= 4) {
                
                while (pj != null) {
                    if (pj.info.price > pi.info.price) {
                        t = pi.info;
                        pi.info = pj.info;
                        pj.info = t;
                    }
                    count++;
                    pj = pj.next;
                }
                
                pi = pi.next;
                
            }
            else
                break;

        }
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Dog x, y;
        x = new Dog("X", 1, 2);
        y = new Dog("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        if (countElement() >= 4) {
            addFirst(x);
            int count = 0;
              Node current = head;
              Node previous = head;
              Node add_y = new Node(y);
             while (count != 3) {
                previous = current;
                current = current.next;
                count++;
            }

            if (current == head) {
                head = add_y;
            } else {
                previous.next = add_y;
                add_y.next = current;
            }
        }
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        if (countElement() >= 4) {
            int count = 0;
            Node temp = head;

            while (temp != null) {

                if (count == 3 || count == 0) {
                    dele(temp);
                }

                temp = temp.next;
                count++;
            }
        }
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        //------------------------------------------------------------------------------------
        sortByPrice();
        ftraverse(f);
        f.close();
    }

}

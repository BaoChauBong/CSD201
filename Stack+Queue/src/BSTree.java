/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bảo Châu
 */
class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    // (1) Tim Node co gtri la x ke tu Node p
    Node search(Node p, int x) {
        if (p == null) {
            return null;
        }
        if (p.info == x) {
            return p;
        }
        if (x < p.info) { // ben trai 
            return search(p.left, x);
        } else {
            return search(p.right, x);
        }
    }

    // (2) Chen Node co gtr la x o sau Node p
    Node insert(Node p, int x) {
        if (p == null) {
            p = new Node(x);
            return p;
        }

        if (x == p.info) {
            return p;
        }

        if (x < p.info) { // chen ben trai
            p.left = insert(p.left, x);
        } else {
            p.right = insert(p.right, x);
        }
        return p;
    }

    // (3) Chen tu goc
    void insert(int x) {
        root = insert(root, x);
    }

    // (4) Chen Node co gtri x vao cay NHUNG KO SU DUNG DE QUY
    void insert2(int x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }

        Node f, p; // f la father cua p -> nam tren p
        f = null;
        p = root;

        while (p != null) {
            if (p.info == x) {
                return;
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x < f.info) {
            f.left = new Node(x);
        } else {
            f.right = new Node(x);
        }
    }

    // (5) Chen mhieu phan tu vao cay
    void insertMany(int[] a) {
        for (int i = 0; i < a.length; i++) {
            insert2(a[i]);
        }
    }

    // (6) Them 1 node p
    void visit(Node p) {
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    // (7) Root - left - Right
    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    // (8) Left - Root - Right
    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        preOrder(p.left);
        visit(p);
        preOrder(p.right);
    }

    // (9) Left - Right - Root
    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        preOrder(p.left);
        preOrder(p.right);
        visit(p);
    }

    // (10) Duyet theo chieu rong
    void breadth(Node p) {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(p);
            if (r.left != null) {
                q.enqueue(r.left);
            }

            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    // (11) Xoa Node co gtr x trong cay
    void deleByCopy(int x) {
        if (isEmpty()) {
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            f = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) {
            return; // Not found
        }
        
        // p la node la
        if (p.left == null && p.right == null){
            if (f == null){ // p la root
                root = null;
                return;
            }
            if (p == f.left){
                f.left = null;
            }
            else {
                f.right = null;
            }
            return;
        }
        
        // p chi co con trai
        if (p.left != null && p.right == null){
            if (f == null){
                root = p.left;
            }else {
                if (p == f.left){
                    f.left = p.left;
                }
                else {
                    f.right = p.left;
                }
            }
            return;
        }
        
        // p chi co con phai
        if (p.left == null && p.right != null){
            if (f == null){
                root = p.left;
            }else {
                if (p == f.left){
                    f.left = p.right;
                }
                else {
                    f.right = p.right;
                }
            }
            return;
        }
        
        // p co ca 2 con
        if (p.left != null && p.right != null){
            Node q = p.left;
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null){
                frp = rp;
                rp = rp.right;
            }
            // rp la not phai cung cua nua trai
            p.info = rp.info;
            if (frp == null){
                p.left = q.left;
                
            }
            else {
                frp.right= rp.left;
            }
        }
    }
}

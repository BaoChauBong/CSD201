
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dell
 */
public class EulerCycle {

    int[] e;
    int m;
    char[] v;

    EulerCycle() {
        e = new int[50];
        m = 0;
        v = "ABCDEFGHIJKLMN".toCharArray();
    }

    void add(int x) {
        e[m++] = x;
    }

    void display(RandomAccessFile f) throws IOException {
        for (int i = 0; i < m - 1; i++) {

            f.writeBytes(v[e[i]] + " ");
        }

        f.writeBytes("" + v[e[m - 1]]);
    }
}

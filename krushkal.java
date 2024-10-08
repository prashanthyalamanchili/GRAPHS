package graphs;
import java.util.Scanner;
public class krushkal {
    public static int find(int v, int s[]) {
        while (s[v] != v)
            v = s[v];
        return v;
    }
    public static void union1(int i, int j, int s[]) {
        s[i] = j;
    }
    public static void kruskal(int n, int c[][]) {
        int count, i, min = 0, j, u = 0, v = 0, k, sum;
        int s[] = new int[n];
        int t[][] = new int[n][2];
        for (i = 0; i < n; i++)
            s[i] = i;
        count = 0;
        sum = 0;
        k = 0;
        while (count < n - 1) {
            min = 999;
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (c[i][j] != 0 && c[i][j] < min) {
                        min = c[i][j];
                        u = i;
                        v = j;
                    }
                }
            }
            if (min == 999) break;  
            i = find(u, s);
            j = find(v, s);
            if (i != j) {
                t[k][0] = u;
                t[k][1] = v;
                k++;
                count++;
                sum += min;
                union1(i, j, s);
            }
            c[u][v] = c[v][u] = 999;
        }
        if (count == n - 1) {
            System.out.println("Cost of Spanning tree: " + sum);
            System.out.println("Spanning tree is:");
            for (k = 0; k < n - 1; k++)
                System.out.println(t[k][0] + "," + t[k][1]);
        } else {
            System.out.println("Spanning tree doesn't exist");
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] c = {
            {0, 10, 6, 5},
            {10, 0, 0, 15},
            {6, 0, 0, 4},
            {5, 15, 4, 0}
        };

        kruskal(n, c);
    }
}

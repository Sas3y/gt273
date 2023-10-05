import java.util.*;

public class java273 {
    public static void BLlst(int n, int m, int[][] b, int[] L, int[] lst) {
        int[] d = new int[n+1];
        int[] fst = new int[n+1];
        // Calculate vertex degrees
        for (int i = 1; i <= 2; ++i)
            for (int j = 1; j <= m; ++j)
                ++d[b[i][j]];
        // Forming lst array
        lst[1] = 0;
        for (int i = 1; i <= n; ++i)
            lst[i+1] = lst[i] + d[i];
        // Forming fst array
        for (int i = 1; i <= n; ++i)
            fst[i] = lst[i] + 1;
        // Forming L array
        for (int j = 1; j <= m; ++j) {
            int k = b[1][j];
            L[fst[k]] = b[2][j];
            ++fst[k];
            k = b[2][j];
            L[fst[k]] = b[1][j];
            ++fst[k];
        }

        /* Sorting in ascending order for each vertex
        for (int i = 1; i <= n; ++i)
            Arrays.sort(L, lst[i] + 1, lst[i+1] + 2);
        */
    }

    public static void printArrays(int[] L, int[] lst) {
        System.out.println("L array:");
        for (int i = 1; i < L.length; ++i)
            System.out.print(L[i] + " ");
        System.out.println();
        
        System.out.println("lst array:");
        for (int i = 1; i < lst.length; ++i)
            System.out.print(lst[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Input
        System.out.println("Enter the number of vertices (n) and edges (m): ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        int[][] b = new int[3][m+1];
        
        System.out.println("Enter the edges (u v):");
        
        for (int j = 1; j <= m; ++j) {
            b[1][j] = scanner.nextInt();
            b[2][j] = scanner.nextInt();
        }
        
        int[] L = new int[2*m+1], lst = new int[n+2];
        
        //Main algo
        BLlst(n, m, b, L, lst);
        
        //Output
        printArrays(L, lst);

        scanner.close();
    }
}

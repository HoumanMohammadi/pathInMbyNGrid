package iav.gridPath;

public class Grid {

    public static int countPathsLoop(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize the first row and first column to 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill in the rest of the grid using a loop
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static int countPathRecursive(int m, int n){
        if (m==1 || n ==1){
            return 1;
        }
        int pathsRight = countPathRecursive(m - 1, n);
        int pathsDown = countPathRecursive(m, n - 1);

        return pathsRight + pathsDown;
    }

    public static void main(String[] args) {
        System.out.println(countPathsLoop(1000,1000));
        System.out.println(countPathRecursive(1000,1000));
    }
}

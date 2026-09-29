// -- Leetcode 2267 -- 
// -- Check if There Is a Valid Parentheses String Path -- 

APPROACH I: 
  // Using Dynamic Programming with-out any helper function 
  
class Solution {

    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int pathLen = n + m - 1;

        if (pathLen % 2 == 1) {
            return false;
        }
        if (grid[0][0] != '(' || grid[n - 1][m - 1] != ')') {
            return false;
        }

        boolean[][][] dp = new boolean[n][m][pathLen + 1];

        dp[0][0][1] = true;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int change = grid[i][j] == '(' ? 1 : -1;

                if (i > 0) {
                    for (int balance = 0; balance <= pathLen; ++balance) {
                        if (!dp[i - 1][j][balance]) {
                            continue;
                        }

                        int next = balance + change;

                        if (next >= 0) {
                            dp[i][j][next] = true;
                        }
                    }
                }

                if (j > 0) {
                    for (int balance = 0; balance <= pathLen; ++balance) {
                        if (!dp[i][j - 1][balance]) {
                            continue;
                        }

                        int next = balance + change;

                        if (next >= 0) {
                            dp[i][j][next] = true;
                        }
                    }
                }
            }
        }

        return dp[n - 1][m - 1][0];
    }
}


/* 

Complexity Analysis
Let W be the machine word size.

Time complexity:
      O(nm(n+m)/W) or O(nm(n+m)).

Suppose the input grid is an n×m matrix. There are n⋅m cells, and each cell has at most n+m states. The time complexity of these transitions depends on the implementation; see the State Transition Implementation Details section above.

Space complexity: 
      O(nm(n+m)).

This is the space cost for the dynamic programming array.


*/ 

APPROACH II: 
  // Using Depth First Search approach within a helper function.

class Solution {
    static Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == ')' || grid[rows - 1][cols - 1] == '(') {
            return false;
        }

        if ((rows + cols - 1) % 2 != 0) {
            return false;
        }

        memo = new Boolean[101][101][201];

        return search(grid, 0, 0, 0);
    }

    private boolean search(char[][] grid, int row, int col, int balance) {
        if (grid[row][col] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return balance == 0;
        }

        if (memo[row][col][balance] != null) {
            return memo[row][col][balance];
        }

        boolean canFormValidPath = false;

        if (row + 1 < grid.length) {
            canFormValidPath = search(grid, row + 1, col, balance);
        }

        if (!canFormValidPath && col + 1 < grid[0].length) {
            canFormValidPath = search(grid, row, col + 1, balance);
        }

        return memo[row][col][balance] = canFormValidPath;
    }
}


/*

Complexity

Time complexity:
    O(m × n × (m + n))

Space complexity:
    O(m × n × (m + n))



*/

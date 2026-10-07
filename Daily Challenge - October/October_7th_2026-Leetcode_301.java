// -- Leetcode 301 -- 
// -- Remove Invalid Parentheses -- 


APPROACH I: 
  // Using Backtracking 
  
import java.util.*;

class Solution {
    private Set<String> valid = new HashSet<>();
    private int miniRemove;

    private void reset() {
        this.valid.clear();
        this.miniRemove = Integer.MAX_VALUE;
    }

    private void recur(String s, int index, int leftCount, int rightCount,
                       StringBuilder expression, int removeCount) {
        if (index == s.length()) {
            if (leftCount == rightCount) {
                if (removeCount <= this.miniRemove) {
                    String poss = expression.toString();
                    if (removeCount < this.miniRemove) {
                        this.valid.clear();
                        this.miniRemove = removeCount;
                    }
                    this.valid.add(poss);
                }
            }
            return;
        }

        char curr = s.charAt(index);
        int len = expression.length();

        // Option 1: remove current char if it's a parenthesis
        if (curr == '(' || curr == ')') {
            recur(s, index + 1, leftCount, rightCount, expression, removeCount + 1);
        }

        // Option 2: keep current char
        expression.append(curr);

        if (curr != '(' && curr != ')') {
            recur(s, index + 1, leftCount, rightCount, expression, removeCount);
        } else if (curr == '(') {
            recur(s, index + 1, leftCount + 1, rightCount, expression, removeCount);
        } else if (curr == ')' && rightCount < leftCount) {
            recur(s, index + 1, leftCount, rightCount + 1, expression, removeCount);
        }

        // Backtrack
        expression.deleteCharAt(len);
    }

    public List<String> removeInvalidParentheses(String s) {
        reset();
        recur(s, 0, 0, 0, new StringBuilder(), 0);
        return new ArrayList<>(valid);
    }
}

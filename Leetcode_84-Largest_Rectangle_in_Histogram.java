// -- Leetcode 84 -- 
// -- Largest Rectangle in Histgram -- 


// Using Stack to store indices

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int area=0;

        for(int i=0;i<=n;i++){
            int currh=(i==n)?0:heights[i];

            while(!st.isEmpty() && currh<heights[st.peek()]){
                int h=heights[st.pop()];
                int w=st.isEmpty()?i:i-st.peek()-1;

                area=Math.max(area,h*w);
            }
            st.push(i);
        }
        return area;

    }
}


/* 
Complexities: 
    Time complexity: 
            O(n) 
    Space complexity: 
            O(n)
*/ 

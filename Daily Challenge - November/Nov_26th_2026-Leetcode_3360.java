// -- Leetcode 3360 -- 
// -- Stone Removal Game --

// Using Simulation 

class Solution {
    public boolean canAliceWin(int n) {
        int rm=10;
        int k=0;

        while(n>=rm){
            n-=rm;
            rm--;
            k++;
        }
        return k%2==1;
    }
}

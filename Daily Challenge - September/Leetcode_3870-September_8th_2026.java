// -- Leetcode 3870 -- 
// -- Count Commas in Range --

APPROCAH I:
// Burte Force 
// Using a helper function to calculate length of the given number and so on. 
class Solution {
    public int countCommas(int n) {
        
        // if(n<999) return 0;
        
        int count=0;
        int l=length(n);
        if(l<=3) return 0;
        if(l>3 && l<5){
            count=count+(n-999);
            // n-=999;
        }
        if(l>4 && l<6){
            count=count+(n-9999)+9000;
            // n-=9999;
        }
        if(l == 6){
            return (n-999);
        }



        return count;
    }
    public int length(int n){
        int l=0;
        int temp=n;
        while(n>0){
            l++;
            n/=10;
        }
        return l;
    }
}

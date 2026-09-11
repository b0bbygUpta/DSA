// -- Leetcode 3483 -- 
// -- Unique 3-Digit Even Numbers -- 

APPROACH I: 
  
class Solution {
    HashSet<Integer> set;

    public int totalNumbers(int[] digits) {
        set=new HashSet<>();
        int n=digits.length;
        int count=0;

        for(int i=0;i<n;i++){
            if(digits[i] == 0){
                continue;
            }
            for(int j=0;j<n;j++){
                if(i == j){
                    continue;
                }
                for(int k=0;k<n;k++){
                    if(k == i || k == j || digits[k]%2 != 0){
                        continue;
                    }
                    int num=digits[i]*100 + digits[j]*10 + digits[k];
                        // if(!set.contains(num)){
                        //     count++;
                        // }
                    set.add(num);
                }
            }
        }
        // if(!set.contains(num)){
        //     count++;
        // }

        // return count;

        return set.size();
    }
}

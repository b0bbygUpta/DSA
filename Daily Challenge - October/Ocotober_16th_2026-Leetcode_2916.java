// -- Leetcode 2916 -- 
// -- Subarrays Distinct Element Sum of Squares II --


APPROACH I:
    // Using Binary Indexed Tree 

class Solution {
    public int sumCounts(int[] nums) {
        int n=nums.length;
        long res=0, curr=0;

        BIT bit=new BIT(n+10);
        Map<Integer,Integer> seen=new HashMap<>();
        long mod=1000000007;
        for(int i=0;i<n;i++){
            int a=nums[i];
            int j=seen.getOrDefault(a,-1)+1;
            long q=bit.query(j,i);
            curr=(curr+q*2+i-j+1)%mod;
            res=(res+curr)%mod;
            bit.add(j,i,1);
            seen.put(a,i);
        }

        return (int) res;
    }
}


class BIT{
    int size;
    long[] tree1;
    long[] tree2;

    public BIT(int n){
        this.size=n;
        this.tree1=new long[n+2];
        this.tree2=new long[n+2];
    }

    private int lowbit(int i){
        return i & -i;
    }

    public void add(int l, int r, int delta){
        Add(l,delta);
        Add(r+1,-delta);
    }

    public long query(int l, int r){
        return Query(r) - Query(l-1);
    }

    private void Add(int i, int delta){
        i+=1;
        long ri=i;
        while(i<=size){
            tree1[i]+=delta;
            tree2[i]+=ri*delta;
            i+=lowbit(i);
        }
    }

    private long Query(int i){
        i+=1;
        long ri=i+1;
        if(i>size){
            i=size;
        }
        long res=0;
        while(i>0){
            res+=ri*tree1[i]-tree2[i];
            i-=lowbit(i);
        }
        return res;
    }



}



/* 
Complexities: 

    Time complexity:
        O(nlogn) 


    Space complexity: 
        O(n) 
*/ 

class ProductOfNumbers {
    private List<Integer> st;
    private int n;

    public ProductOfNumbers() {
        st=new ArrayList<Integer>();
        st.add(1);
        n=0;    
    }
    
    public void add(int num) {
        if(num == 0){
            st.clear();
            st.add(1);
            n=0;
            return;
        }
        st.add(st.get(n)*num);
        n++;
    }
    
    public int getProduct(int k) {
        if(k > n) return 0;
        return(
            st.get(n)/
            st.get(n-k)
        );
    }
}


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



class ProductOfNumbers {
    private Stack<Integer> st=new Stack<>();
    private int size=0;

    public ProductOfNumbers() {
        // st.push(1);
        this.st.push(1);
        this.size=0;

    }
    
    public void add(int num) {
        if(num == 0){
            // st=new Stack<Integer>();
            // st.add(1);
            this.st=new Stack<>();
            this.st.push(1);
            size=0;

        }else{
            // st.add(st.peek()*num);
            this.st.push(this.st.get(size)*num);
            this.size++;
        }
    }
    
    public int getProduct(int k) {
        // if(k >= st.size()) return 0;
        if(k > this.size) return 0;

        // int n=st.size();
        // return(
        //     st.get(n-1)/
        //     st.get(n-k-1)
        // );

        return(
            this.st.get(this.size)/
            this.st.get(this.size-k)
        );
    }
}


class ProductOfNumbers {

    private Stack<Integer> st;

    public ProductOfNumbers() {
        st=new Stack<>();

    }
    
    public void add(int num) {
        st.push(num);

        // System.out.println("st: "+st.toString());


    }
    
    public int getProduct(int k) {

        int res=1;

        for(int i=k;i>0;i--){
            res*=st.get(st.size()-i);
        }

        return res;


    }
}

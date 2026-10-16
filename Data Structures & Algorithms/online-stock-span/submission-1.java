class StockSpanner {

    Deque<int[]> st;

    public StockSpanner() {

        st = new ArrayDeque<>();
        
    }
    
    public int next(int price) {

        int sum = 1;

        while(!st.isEmpty() && st.peek()[0] <= price) {

            sum = sum + st.peek()[1];
            st.pop(); 
        }

        st.push(new int[]{price, sum});

        return sum;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
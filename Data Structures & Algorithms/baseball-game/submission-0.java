class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> st = new Stack<>();
        int n = operations.length;
        int result = 0;

        for(int i=0; i<n; i++) {

            if (operations[i].equals("+")) {

                    int x = st.pop();
                    int y = st.peek();
                    int res = x + y;
                    st.push(x);
                    st.push(res); 
                    
            } else if (operations[i].equals("C")) {

                st.pop();

            } else if (operations[i].equals("D")) {
                if (!st.isEmpty()) {
                    int y = st.peek();
                    st.push(2*y);
                }

            } else {

                st.push(Integer.parseInt(operations[i]));

            }
        }

        while (!st.isEmpty()) {

            result += st.pop();

        }

        return result;
        
    }
}
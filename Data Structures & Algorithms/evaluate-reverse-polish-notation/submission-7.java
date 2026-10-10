class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for(String s: tokens) {

            if(isOperator(s)) {

                int b = st.pop();
                int a = st.pop();

                Integer result = calculateValue(a, b, s);

                st.push(result);
                

            } else {

                st.push(Integer.parseInt(s));

            }

        }

        return st.peek();
    }

    public boolean isOperator(String ch) {

            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                return true;
            } else {
                return false;
            }
    }

    public Integer calculateValue(int a, int b,String s) {

        switch(s) {
            case "+":return a + b;

            case "*":return a * b;

            case "/": return b == 0 ? 0 : a/b;

            case "-":return a - b;

            default: throw new IllegalArgumentException();
        }
    }
    
}

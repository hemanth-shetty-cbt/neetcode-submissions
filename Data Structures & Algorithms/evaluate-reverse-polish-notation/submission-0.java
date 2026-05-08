class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for(String s: tokens) {

            if(isOperator(s)) {

                int b = st.pop();
                int a = st.pop();

                int result = operateResult(a, b, s);

                st.push(result);
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        
        return st.pop();
    }

    public boolean isOperator(String s) {
      
      if(s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")) {
        return true;
      } else {
        return false;
      }
    }

    public int operateResult(int a, int b, String s) {

        switch(s) {
            case "+": return a + b;

            case "-": return a - b;

            case "*": return a * b;

            case "/": return a / b;

            default: throw new IllegalArgumentException("Invalid operator");
        }
    }
}

class Solution {
    public boolean isValid(String s) {

        HashMap<Character, Character> mp = new HashMap<>();

        mp.put('}','{');
        mp.put(')','(');
        mp.put(']','[');

        if (s.length() <= 1) {
            return false;
        }

        Stack<Character> st = new Stack<>();
        char top;

        for (char c:s.toCharArray()) {

            if (!mp.containsKey(c)) {
                st.push(c);
            } else{

                if (st.isEmpty()) {
                    return false;
                }
                

                top = st.pop();

                if (mp.get(c) != top) {
                    return false;
                }
            }
        }

       return st.isEmpty();
        
        
    }
}

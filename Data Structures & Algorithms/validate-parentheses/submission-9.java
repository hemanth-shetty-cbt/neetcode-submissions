class Solution {
    public boolean isValid(String s) {

        if (s.length() < 1) {
            return false;
        }

        HashMap<Character, Character> mp = new HashMap<>();
        mp.put('}', '{');
        mp.put(')','(');
        mp.put(']','[');

        Stack<Character> st = new Stack<>();

        for (char ch:s.toCharArray()) {

            if (!mp.containsKey(ch)) {
                st.push(ch);
            } else {

                if (st.isEmpty()) {
                    return false;
                }

                char top = st.pop();

                if (!mp.get(ch).equals(top)) {
                    return false;
                }
            }
        }

    return st.isEmpty();

        
    }
}

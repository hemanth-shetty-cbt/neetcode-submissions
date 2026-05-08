class Solution {
    public boolean isValid(String s) {

        HashMap<Character, Character> mp = new HashMap<>();

        Stack<Character> st = new Stack<>();
        mp.put(')', '(');
        mp.put('}', '{');
        mp.put(']', '[');

        char topElement;

        for(Character c: s.toCharArray()) {

            if(!mp.containsKey(c)) {
                st.add(c);
            } else {

                if (st.isEmpty()) {
                    return false;
                }

                topElement = st.pop();

                if(topElement != mp.get(c)) {
                    return false;
                }
            }
        }

        return st.isEmpty();
        
    }
}

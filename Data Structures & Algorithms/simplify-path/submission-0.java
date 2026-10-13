class Solution {
    public String simplifyPath(String path) {

        Deque<String> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();


        for (String str : path.split("/")) {

            if (str.isEmpty() || str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }

            } else {
                st.push(str);
            }

        }

        if (st.isEmpty()) {
            return "/";
        }

        Iterator<String> itr = st.descendingIterator();

        while(itr.hasNext()) {
            sb.append("/").append(itr.next());
        } 
        
        return sb.toString();
    }
}
class Solution {
    public String decodeString(String s) {

        Deque<Integer> numCount = new ArrayDeque<>();
        Deque<String> charCount = new ArrayDeque<>();

        StringBuilder current = new StringBuilder();
        int num = 0;
        

        for (Character ch:s.toCharArray()) {

            if (Character.isDigit(ch)) {

              num = num * 10 + (ch - '0');
            } else if (ch.equals('[')) {

                numCount.push(num);
                charCount.push(current.toString());
                num = 0;
                current = new StringBuilder();


            } else if (ch.equals(']')) {

                String prev = charCount.pop();
                int top = numCount.pop();

                StringBuilder result = new StringBuilder(prev);

                for (int i=0; i<top; i++) {

                    result.append(current);
                } 

                current = result;

            } else {
                current.append(ch);
            }

        }

        return current.toString();
        
    }
}
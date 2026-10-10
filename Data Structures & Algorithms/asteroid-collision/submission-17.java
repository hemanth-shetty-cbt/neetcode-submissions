class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;

        for (int i = 0; i < n; i++) {
            if (st.empty()) {
                st.push(asteroids[i]);
                continue;
            }

            int curr = asteroids[i];
            int topEle = st.peek();

            // top of stack is moving left and new astroid moving right
            // cannot collide
            if(topEle<0 && curr>0) {
                st.push(asteroids[i]);
                continue;
            }

            // top of the stack and new asteroid in the same direction
            if (topEle * curr > 0) {
                st.push(asteroids[i]);
            }else {
                // int diff = Math.abs(asteroids[i]) - Math.abs(topele);
                int diff = Math.abs(topEle) - Math.abs(curr);

                if (diff == 0) {
                    st.pop();
                } else if(diff > 0){       
                        continue;
                }else{
                    
                    st.pop();
                    // the top element has collided with the new asteroid and got destroyed

                    int newTopEle;

                    boolean shouldPushCurr = st.empty();

                    while(!st.empty()){

                        newTopEle = st.peek();

                        if(newTopEle * curr > 0){
                            shouldPushCurr = true;
                            break;
                        }else if (Math.abs(curr) > Math.abs(newTopEle)){
                            shouldPushCurr = true;
                            st.pop();
                        } else if(Math.abs(curr) < Math.abs(newTopEle)){
                            shouldPushCurr = false;
                            break;
                        }else if(Math.abs(curr) == Math.abs(newTopEle)){
                            shouldPushCurr = false;
                            st.pop();
                            break;
                        }

                    }

                    if(shouldPushCurr)
                        st.push(curr);
                    

                }
            }
        }

        int[] result = new int[st.size()];

        for (int i=st.size()-1; i>=0; i--) {
            result[i] = st.pop();
        }
        
        return result;
    }
}
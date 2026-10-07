class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n  = s.length();

        int left =0, right = 0;
        int max = 0;

        Set<Character> mp = new HashSet<>();

        while(right < n) {

            if (mp.contains(s.charAt(right))) {

                mp.remove(s.charAt(left));
                left++;


            } else {
                mp.add(s.charAt(right));
                int sum = right - left +1;
                max = Math.max(max, sum);
                right++;
            }
        }

        return max;

        
    }
}

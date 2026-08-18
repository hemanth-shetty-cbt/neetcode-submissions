class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max= 0;
        int n = s.length();

        int left=0, right = 0;
        HashSet<Character> mp = new HashSet<>();

        while (right < n) {

            if (mp.contains(s.charAt(right))) {
                mp.remove(s.charAt(left));
                left++;

            } else {
                mp.add(s.charAt(right));
                
                max = Math.max((right-left + 1), max);
                right++;
            }
        }

        return max;
        
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int ans = 0 , left = 0, right = 0;

        int n = s.length();

        HashSet<Character> mp = new HashSet<>();
        while (right < n) {

            char str = s.charAt(right);

            while(mp.contains(str)) {
                mp.remove(s.charAt(left));
                left++;
            }

            mp.add(str);
            ans = Math.max(ans, right-left+1);
            right++;
        }

        return ans;
    }
}

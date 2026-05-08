class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right =0,max = 0, maxLength = 0, n = s.length();
        int arr[] = new int[26];

        while(right<n) {

            arr[s.charAt(right) - 'A']++;
            max = Math.max(max, arr[s.charAt(right) - 'A']);

            if(right - left + 1 - max > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right-left+1 );
            right++;
        }

        return maxLength;
        
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        
        int a[] = new int[26];
        int b[] = new int[26];

        if (s1.length() > s2.length()) {
            return false;
        }

        //build the s1 window with frequency

        for (char ch: s1.toCharArray()) {
            a[ch - 'a']++;
        }

        int windowSize= s1.length();

        //build the 1st index of b.
        for (int i=0; i<windowSize; i++) {
            b[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(a,b)) {
            return true;
        }

        for (int right = windowSize; right < s2.length(); right++) {

            b[s2.charAt(right) - 'a']++;

            //need to eliminate the left index one

            int left = right - windowSize; 

            b[s2.charAt(left) - 'a']--;

            if (Arrays.equals(a,b)) {
                return true;
            }

        }

        return false;
        
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) 
            return false;
        


        int[] a = new int[26];
        int[] b = new int[26];

        for (char ch:s1.toCharArray()) {
            a[ch - 'a']++;
        }

        int window = s1.length();

        for (int i=0; i<window; i++) {
            b[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(a,b)) {
            return true;
        }

        for (int right = window ; right<n2; right++) {

            int left = right - window;


            b[s2.charAt(right) - 'a']++;

            b[s2.charAt(left) - 'a']--;

            if (Arrays.equals(a,b)) {
                return true;
            }
        }

        return false;


        
    }
}

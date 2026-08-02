class Solution {
    public boolean isAnagram(String s, String t) {

        s = s.toUpperCase();
        t = t.toUpperCase();

        int[] arrr = new int[26];

        Arrays.fill(arrr, 0);

        if (s.length() != t.length()) {
            return false;
        }

        for (int i=0; i<s.length(); i++) {

            arrr[s.charAt(i) - 'A']++;
        }

         for (int i=0; i<t.length(); i++) {
            
            arrr[t.charAt(i) - 'A']--;

        }

        for (int i=0; i< 26; i++) {
            
            if(arrr[i] != 0) {
                return false;
            }
        }

        return true;

    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {

        int n = strs[0].length();
        int t = strs.length;
        String sb  = null;

        if (n==0 || strs.length == 0) {
            return "";
        }

        for (int i=0; i<n; i++) {

            char ch = strs[0].charAt(i);

                for (int j=1; j<t; j++) {

                    if (strs[j].length() == i || 
                    strs[j].charAt(i) != ch) {
                        return strs[0].substring(0, i);
                    }

                }
        }

        return strs[0];
    
    }
}
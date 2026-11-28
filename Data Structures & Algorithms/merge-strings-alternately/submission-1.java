class Solution {
    public String mergeAlternately(String word1, String word2) {

        int left1 = 0, left2 = 0;
        int n1 = word1.length(), n2 = word2.length();

        StringBuilder sb = new StringBuilder();


        while (left1 < n1 && left2 < n2) {

            sb.append(word1.charAt(left1++));
            sb.append(word2.charAt(left2++));
            
        }

        while (left1 < n1) {
            sb.append(word1.charAt(left1++));

        }
        
        while (left2 < n2) {
            sb.append(word2.charAt(left2++));
            
        }

        return sb.toString();
    }
}
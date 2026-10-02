class Solution {
    public void reverseString(char[] s) {
        int n = s.length;

        int i=0,l=n-1;
        while(i <l) {
            char temp;
            temp = s[i];
            s[i] = s[l];
            s[l] = temp;
            i++;
            l--;
        }


    
    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {

                int left = 0;
        int n1 = s1.length();
        int n2 = s2.length();

        int arr[] = new int[26];
        int win[] = new int[26];


        if(n1 > n2) {
            return false;
        }

        for(int i=0; i<n1; i++) {

           arr[s1.charAt(i) - 'a']++;
        }

       

        for(int right=0 ; right<n2; right++) {

            win[s2.charAt(right) - 'a']++;

            if(right - left + 1 > n1) {
                win[s2.charAt(left) - 'a']--;
                left++;
            }

            if(matches(arr, win)) {
                return true;
            }
        }
    
    return false;
    }

    private boolean matches(int[] a1, int[] a2) {

            for(int i=0;i<26;i++) {
                if(a1[i] != a2[i]) {
                    return false;
                }
            }

            return true;
        }
        
}

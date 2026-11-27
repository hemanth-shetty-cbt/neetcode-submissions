class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int count1 = 0, count2 = 0, element1 = 0, element2 = 0;
        int n = nums.length;

        for (int num: nums) {

            if (count1 == 0 && num != element2) {
                element1 = num;
                count1++;
            } else if (count2 == 0 && num != element1) {
                element2 = num;
                count2++;
            } else if (num == element1) {
                count1++;
            } else if (num == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();
        count1= 0;
        count2 =0;

        for (int i:nums) {

            if (i == element1)
                count1++;
            
            if (i == element2)
                count2++;


        }
        if (count1 > (n/3))
            result.add(element1);

        if (count2 > (n/3))
             result.add(element2);

       
       

        return result;
    
        
    }
}
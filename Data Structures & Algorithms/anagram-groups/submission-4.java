class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        
        Map<String, List> mp = new HashMap<>();
        int[] arr = new int[26];

        for (String st: strs) {

            Arrays.fill(arr,0);


            for (char ch:st.toCharArray()) {
                arr[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i=0; i<26; i++) {
                sb.append("#");
                sb.append(arr[i]);
            }

            String key = sb.toString();

            if (!mp.containsKey(key)) {
                mp.put(key , new ArrayList());
            }

            mp.get(key).add(st);

        }

        return new ArrayList(mp.values());
        
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String , List> mp = new HashMap<> ();

        int [] count = new int [26];

        for (String s : strs) {

            Arrays.fill(count, 0);
            
            for (char ch : s.toCharArray()) {
                count [ch - 'a']++;

            }

            StringBuilder sb = new StringBuilder();

            for (int i=0; i<26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }

            String key  = sb.toString();

            if (!mp.containsKey(key)) {

                mp.put(key, new ArrayList());
            }

            mp.get(key).add(s);
        }

        return new ArrayList(mp.values());

       
    }
}

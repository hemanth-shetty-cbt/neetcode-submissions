class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {


    //checking the length
     if(strs.length == 0) {
        return new ArrayList();
     }

    int [] count = new int[26];

    HashMap<String, List> map = new HashMap<>();

    for( String s: strs) {

     Arrays.fill(count, 0);

     for(char c: s.toCharArray()) {
         count[c - 'a']++;
     }

     StringBuilder sb = new StringBuilder();
     
     for(int i=0 ; i<26; i++) {

        sb.append("#");
        sb.append(count[i]);
     }

     String key = sb.toString();

     if(!map.containsKey(key)) {

        map.put(key, new ArrayList());
     }

    map.get(key).add(s);
    }
    
     return new ArrayList(map.values());   
    }
        
}

class Solution {

    public String encode(List<String> strs) {

    List<Integer> sizes = new ArrayList<>();

    StringBuilder sb = new StringBuilder();

    for(String st:strs){
        sizes.add(st.length());
    }

    for (int i: sizes) {
        sb.append(i);
        sb.append(',');
    }
    sb.append('#');

    for(String str: strs) {
        sb.append(str);
    }

    return sb.toString();
}

    public List<String> decode(String str) {

        if (str.isEmpty() || str ==  null) {
            return new ArrayList<>();
        }

        List<Integer> sizes = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int i = 0;

        while (str.charAt(i) != '#') {

            StringBuilder sb = new StringBuilder();

            while(str.charAt(i) != ',') {
                sb.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(sb.toString()));
            i++;
        }
        i++;

        for(int j: sizes) {

            result.add(str.substring(i,i+j));
            i = i+j;
        }

        return result;
    }
}

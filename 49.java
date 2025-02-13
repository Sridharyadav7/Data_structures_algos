class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int cnt=-1;
        for(int i=0;i<strs.length;i++){
            char c[] = strs[i].toCharArray();
            Arrays.sort(c);
            String curr=new String(c);

            if(!map.containsKey(curr)){
                cnt++;
                map.put(curr,cnt);
                ans.add(new ArrayList<>(Arrays.asList(strs[i])));
            }
            else{
                int pos=map.get(curr);
                ans.get(pos).add(strs[i]);
            }

        }
        return ans;
    }
}
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        int ans[] = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(stack.empty()){
                map.put(nums2[i],-1);
                stack.push(nums2[i]);
            }
            else if(stack.peek()>nums2[i]){
                map.put(nums2[i],stack.peek());
                stack.push(nums2[i]);
            }
            else{
                while(!stack.empty() && stack.peek()<=nums2[i]){
                    stack.pop();
                }
                if(!stack.empty()){
                    map.put(nums2[i],stack.peek());
                    stack.push(nums2[i]);
                }
                else{
                    map.put(nums2[i],-1);
                    stack.push(nums2[i]);
                }
            }
        }
        for(int i=0;i<ans.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}
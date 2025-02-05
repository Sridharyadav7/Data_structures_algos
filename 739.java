class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        Stack<int[]> stack = new Stack<>();
        int len=0;
        for(int i=n-1;i>=0;i--){
            if(stack.empty()){
                ans[i]=0;
                stack.push(new int[]{temperatures[i],i});
            }
            else if(stack.peek()[0]>temperatures[i]){
                ans[i]=stack.peek()[1]-i;
                stack.push(new int[]{temperatures[i],i});
            }
            else{
                while(!stack.empty() && stack.peek()[0]<=temperatures[i]){
                    stack.pop();
                }
                if(!stack.empty()){
                    ans[i]=stack.peek()[1]-i;
                    stack.push(new int[]{temperatures[i],i});
                }
                else{
                    ans[i]=0;
                    stack.push(new int[]{temperatures[i],i});
                }
            }
        }
        return ans;
    }
}
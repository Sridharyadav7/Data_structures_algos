class Solution {
    public int climbStairs(int n) {
        int result=f(n);
        return result;
    }
    public int f(int n){
        if(n==0 || n==1){
            return 1;
        }
        else{
            int prev2=1;
            int prev=1;
            int i=2;
            while(i<n){
                int curr=prev+prev2;
                prev2=prev;
                prev=curr;
                i++;
            }
            return prev2+prev;
        }
    }
}
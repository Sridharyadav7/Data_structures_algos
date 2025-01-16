class Solution {
    public int maxProfit(int[] prices) {
        int buy=0;
        int sell=1;
        List<Integer> profits = new ArrayList<Integer>();
        while(sell<prices.length){
            if(prices[sell]>prices[buy]){
                profits.add(prices[sell]-prices[buy]);
                buy++;
                sell++;
            }
            else if(prices[sell]<=prices[buy]){
                buy++;
                sell++;
            }
        }
        int sum=0;
        for(int i=0;i<profits.size();i++){
            sum=sum+profits.get(i);
        }
        return sum;
    }
}
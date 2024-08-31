public class Stockbuyandsell {
    public static void main(String[] args)
    {
        int[] prices={7,1,5,3,6,4};
        int min=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<min)
            {
                min=prices[i];
            }
            if((prices[i]-min)>profit)
            {
                profit=prices[i]-min;
            }
        }  
        System.out.println(profit); 
    }
    
}

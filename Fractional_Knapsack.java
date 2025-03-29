//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int i=0;
        double maxVal=0.0;
        int currCapacity=0;
        List<Item> items = new ArrayList<>();
        for(int j=0;j<val.size();j++){
            items.add(new Item(val.get(j),wt.get(j)));
        }
        Collections.sort(items, new itemComparator());
        while(i<items.size()){
            if(items.get(i).weight+currCapacity<=capacity){
                currCapacity+=items.get(i).weight;
                maxVal+=items.get(i).value;
            }
            else{
                maxVal+=((double)items.get(i).value/(double)items.get(i).weight)*(capacity-currCapacity);
                break;
            }
            i++;
        }
        return Math.round(maxVal * 1_000_000) / 1_000_000.0;    }
}

class itemComparator implements Comparator<Item>{
    @Override
    public int compare(Item a, Item b){
        double r1 = (double)(a.value) / (double)(a.weight);  
        double r2 = (double)(b.value) / (double)(b.weight); 
        
        if(r1>r2) return -1;
        else if(r1<r2) return 1;
        return 0;
    }
}

class Item {
    int value, weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}
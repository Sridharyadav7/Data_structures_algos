import java.util.*;
import java.util.Map.Entry;

public class HighestLowest_Frequency_element
{
    public static void main(String[] args)
{
    int N = 4; 
    int[] arr = {2,2,3,4,4,2};
    int p = 3;
    HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();
    for(int i=0;i<arr.length;i++)
    {
        if(map.containsKey(arr[i]))
        {
            map.put(arr[i], map.get(arr[i])+1);
        }
        else
        {
            map.put(arr[i],1);
        }
    }
    int max_value=(Collections.max(map.values()));
    int min_value=(Collections.min(map.values()));
    int max_key=0;
    int min_key=0;
    for(Entry<Integer, Integer> entry: map.entrySet()) 
    {

        // if give value is equal to value from entry
        // print the corresponding key
        if(entry.getValue() == max_value) {
          max_key=entry.getKey();
        }
        if(entry.getValue()==min_value)
        {
            min_key=entry.getKey();
        }
    }
    System.out.println(max_key+" "+min_key);
}
}



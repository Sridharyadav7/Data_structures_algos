import java.util.*;
import java.util.Map.Entry;

public class ArrayUnion
{
    public static void main(String[] args)
{
    int[] a={1,2,3,4,5,6,7,8,9,10};
    int[] b={2,3,4,4,5,11,12};
    Set<Integer> arr1=new HashSet<Integer>();
    Set<Integer> arr2=new HashSet<Integer>();
    for(int i=0;i<a.length;i++)
    {
        arr1.add(a[i]);
    }
    for(int i=0;i<b.length;i++)
    {
        arr2.add(b[i]);
    }
    List<Integer> num1=new ArrayList<>(arr1);
    List<Integer> num2=new ArrayList<>(arr2);
    for(int i=0;i<num2.size();i++)
    {
        if(!num1.contains(num2.get(i)))
        {
            num1.add(num2.get(i));
        }
    }
    num1.sort(null);
    System.out.println(num1);
}
}




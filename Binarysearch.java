import java.util.Arrays;
import java.util.Scanner;

public class Binarysearch {

    public static void main(String[] args)
    {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the length of array: ");
    int n=sc.nextInt();
    int[] items=new int[n];
    System.out.println("Enter array elements with spaces: ");
    for(int i=0;i<items.length;i++)
    {
        items[i]=sc.nextInt();
    }
    System.out.println("Enter the key: ");
    int key=sc.nextInt();
    Arrays.sort(items);
    System.out.println("Sorted array: ");
    for(int i=0;i<items.length;i++)
    {
        System.out.print(items[i]+" ");
    }
    Binary b=new Binary();
    int result=b.check(items,0,items.length-1,key);
    if(result == -1)
    {
        System.out.println("\nElement not present");
    }

    else
    {
        System.out.println("\nElement present at: " + (result+1));
    }
}
    
}

class Binary
{
    int check(int[] arr,int low,int high,int key)
    {
    int mid=(low+high)/2;
    if(low>high)
    {
        return -1;
    }
    if(arr[mid]==key)
        return mid;
    else if(arr[mid]<key)
    {
        return check(arr,mid+1,high,key);
    }
    else if(arr[mid]>key)
    {
        return check(arr,low,mid-1,key);
    }
    else
    {
        return -1;
    }
}
}
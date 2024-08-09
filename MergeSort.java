import java.util.ArrayList;

public class MergeSort
{
    public static void main(String[] args)
    {
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        Sorting obj=new Sorting();
        obj.mergesort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }      
    }
}

class Sorting 
{
    public void mergesort(int[] arr,int low,int high)
    {
        if(low==high)
        {
            return;
        }
        else
        {
            int mid=(low+high)/2;
            mergesort(arr,low,mid);
            mergesort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    public void merge(int[] arr,int low,int mid,int high)
    {
        ArrayList<Integer> temp=new ArrayList<Integer>();
        int left=low;
        int right=mid+1;
        while(left<=mid && right<=high)
        {
            if(arr[left]<=arr[right])
            {
                temp.add(arr[left]);
                left++;
            }
            else
            {
                temp.add(arr[right]);
                right++;
            }
        }

        while(left<=mid)
        {
            temp.add(arr[left]);
            left++;
        }
        while(right<=high)
        {
            temp.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++)
        {
            arr[i]=temp.get(i-low);
        }
    }
}

import java.util.Scanner;

public class array {
    public static void main(String[] args)
    {
        int[][] items=new int[3][3];
        Scanner sc= new Scanner(System.in);

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                items[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the item to be searched: ");
        int key=sc.nextInt();
        Linearsearch a=new Linearsearch();
        int[] result=a.check(items,key);
        if(result[0]==1)
        {
            System.out.println("Item found at position "+result[1]+","+result[2]);
        }
        else{
            System.out.println("Item not found");
        }
       
}}

class Linearsearch
{
    int[] check(int[][] items, int key)
    {
        for(int i=0;i<items.length;i++)
        {
            for(int j=0;j<items[i].length;j++)
            {
                if(items[i][j]==key)
                 {
                       return new int[]{1,i,j};
                 }
            }
        }
        return new int[]{0,-1,-1};
    }
}

import java.util.*;

public class RemoveOutermostParenthesis
{
    public static void main(String[] args)
{
    String s="()()";
    int curr=0;
    int j=0;
    String result=new String();
    for(int i=0;i<s.length();i++)
    {
        if(s.charAt(i)=='(')
        {
            j++;
        }
        else if(s.charAt(i)==')')
        {
            j--;
        }
        if(j==0)
        {
            result=result+s.substring(curr+1,i);
            curr=i+1;
        }
    }
    System.out.println(result);
    
    
}
}






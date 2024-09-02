import java.util.*;

public class ReverseWordsInString
{
    public static void main(String[] args)
{
    String s="a good   example";
    s=s.trim();
    String str=new String();
    int end=s.length()-1;
    for(int i=s.length()-1;i>=0;i--)
    {
        if(s.charAt(i)==' ')
        {
            String temp=s.substring(i+1,end+1);
            str=str+temp;
            if(s.charAt(i-1)!=' ')
            {
                str=str.concat(" ");    
            }
            end=i-1;       
        }
        if(i==0)
        {
            String temp=s.substring(i,end+1);
            str=str+temp;
        }
    }
    System.out.println(str);
}
}






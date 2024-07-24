public class arrow {
    public static void main(String args[])
    {
        int count=1;
        int m=3;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<count;j++)
            {
                System.out.print('*');
            }
            System.out.println();
            count++;
        }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print('*');
            }
            System.out.println();
            m--;
        }
    }
    
}

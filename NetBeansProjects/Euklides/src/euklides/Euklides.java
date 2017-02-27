package euklides;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Euklides 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File f = new File("\\.new.txt");
        Scanner in = new Scanner(f);
        while(in.hasNextLine())
        {
            String[] input = in.nextLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            //wersja interacyjna
            while(a!=b)
            {
                if(a>b)
                {
                    a-=b;
                }
                else
                {
                    b-=a;
                }
            }
            //wersja rekurencyjna
            euklides(a,b);
        }
    }
    private static int euklides(int a,int b)
    {
        if(a!=b)
        {
            if(a>b)return euklides(a-b, b);
            else return euklides(a, a-b);
        }
        else return a;
    }
}

package naczynniki;
import java.util.*;
import java.io.*;
public class NaCzynniki
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File f = new File(".\\new.txt");
        Scanner in = new Scanner(f);
        while(in.hasNextLine())
        {
            int a = Integer.parseInt(in.nextLine());
            String wynik = "1";
            int k = 2;
            while(a>1)
            {
                while(a%k==0)
                {
                    wynik+= " * "+k;
                    a/=k;
                }
                k++;
            }
            System.out.println(wynik);
        }
    }
}

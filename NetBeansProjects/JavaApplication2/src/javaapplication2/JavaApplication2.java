package javaapplication2;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class JavaApplication2 
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
            File f = new File("C:\\java\\NetBeansProjects\\JavaApplication2\\build\\classes\\javaapplication2\\Query2.txt");
            Scanner in = new Scanner(f);
            int i =0;
            int m=0;
            int k=0;
            while(i<70)
            {
                String a = in.nextLine();
                int x = Integer.parseInt(a.substring(9))/10;
                if(x%2==0)k++;
                else m++;
                i++;
            }
            System.out.println("m= "+m+" k= "+k);
    }
}

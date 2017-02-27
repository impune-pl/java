package javaapplication2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class JavaApplication21 
{
    public static void main(String[] args) throws FileNotFoundException
    {
            File f = new File("C:\\java\\NetBeansProjects\\JavaApplication2\\build\\classes\\javaapplication2\\punkty.txt");
            Scanner in = new Scanner(f);
            
            int iloscPunktow = 100;
            int i=0;
            
            System.out.println("punkty należące do brzegu koła:");
            while(in.hasNextLine())
            {
                String curr = in.nextLine();
                String[] coord = curr.split(":");
                int x = Integer.parseInt(coord[0]);
                int y = Integer.parseInt(coord[1]);
                Double L = Math.pow((double)(x-200), 2) + Math.pow((double)(y-200), 2);
                if(L.compareTo(Math.pow((double)200, 2))==0)
                {
                    System.out.println(x+" ; "+y);
                }
                if(i == iloscPunktow)break;
            }
            
            
            in = new Scanner(f);
            System.out.println("punkty należące do koła:");
            i=0;
            
            while(in.hasNextLine())
            {
                String curr = in.nextLine();
                String[] coord = curr.split(":");
                int x = Integer.parseInt(coord[0]);
                int y = Integer.parseInt(coord[1]);
                Double L = Math.pow((double)(x-200), 2) + Math.pow((double)(y-200), 2);
                if(L.compareTo(Math.pow((double)200, 2))<0)
                {
                    System.out.println(x+" ; "+y);
                }
                if(i == iloscPunktow)break;
            }
            
            
            
            System.out.println(i);
            double n = i;
            double pi = n*4/iloscPunktow;
            String ne = String.format("%f", pi);
            System.out.println(ne);
            double error = Math.abs(Math.PI - pi);
            System.out.println(error);
    }
}

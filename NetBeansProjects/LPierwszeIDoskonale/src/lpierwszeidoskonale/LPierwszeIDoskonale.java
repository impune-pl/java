package lpierwszeidoskonale;
import java.io.*;
import java.util.*;
public class LPierwszeIDoskonale 
{
    public static void main(String[] args) throws IOException
    {
        File f = new File(".\\new.txt");
        Scanner in = new Scanner(f);
        while(in.hasNextLine())
        {
            String linia = in.nextLine();
            linia = linia.trim();
            int badana = Integer.parseInt(linia);
            if(czyPierwsza(badana))
                System.out.println(badana+" jest Pierwsza");
            else if(czyDoskonala(badana))
                System.out.println(badana +" Doskonała");
        }
    }
    private static boolean czyPierwsza(int badana)
    {
        int i = 2;
        int ilosc = 0;
        if(badana<2)return false;
        while(i*i<=badana)
        {
            if(badana%i==0)
            {
                if(badana / i !=i)
                {
                    ilosc++;
                }
                ilosc++;
            }
            i++;
            if(ilosc>0)return false;
        }
        return true;
    }
    private static boolean czyDoskonala(int badana)
    {
        int i=2;
        int suma = 1;
        while(i*i<=badana)
        {
            if(badana %i==0)
            {
                suma += i;
                if(badana / i !=i)
                {
                    suma += badana/i;
                }
            }
            i++;
        }
        if(suma==badana)return true;
        else return false;
    }
    
}

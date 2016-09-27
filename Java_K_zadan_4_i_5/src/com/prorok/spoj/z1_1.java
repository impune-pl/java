package com.prorok.spoj;
import java.util.Scanner;

public class z1_1
{
    z1_1()
    {
        System.out.println("Podaj numer miesiąca");
        Scanner in = new Scanner(System.in);
        int x=in.nextInt();
        if(x<=12&&x>0)
        {
            if (x <= 2) System.out.println("zima");
            else if (x <= 6) System.out.println("wiosna");
            else if (x <= 9) System.out.println("lato");
            else if (x <= 11) System.out.println("jesień");
            else System.out.println("zima");
        }
        else System.out.println("Error!!!");
    }
}

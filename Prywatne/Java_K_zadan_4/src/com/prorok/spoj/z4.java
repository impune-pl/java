package com.prorok.spoj;

import java.util.Scanner;

public class z4
{
    z4()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj a:");
        int a = in.nextInt();
        System.out.println("Podaj b:");
        int b = in.nextInt();
        boolean x= false;
        if(b>0&&a%b==0)
        {
            System.out.println("Tak");
            x=true;
        }
        else System.out.println("Nie");
    }
}

package com.prorok.spoj;


import java.util.Scanner;

public class z3
{
    z3()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj a:");
        int a = in.nextInt();
        System.out.println("Podaj b:");
        int b = in.nextInt();
        if(b>0&&a%b==0)System.out.println("Tak");
        else System.out.println("Nie");
    }
}

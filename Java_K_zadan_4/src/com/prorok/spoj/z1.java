package com.prorok.spoj;

import java.util.Scanner;

public class z1
{
    z1()
    {
        System.out.println("Podaj długość boków:");
        Scanner in = new Scanner(System.in);
        System.out.print("a: ");
        Double a =in.nextDouble();
        System.out.print("b: ");
        Double b =in.nextDouble();
        System.out.print("c: ");
        Double c =in.nextDouble();
        if(a+b>c&&a+c>b&&b+c>a)System.out.println("Tak");
        else System.out.println("Nie");
    }
}

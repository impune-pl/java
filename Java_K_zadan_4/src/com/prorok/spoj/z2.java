package com.prorok.spoj;


import java.util.Scanner;

public class z2
{
    z2()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj numer dnia:");
        int x =in.nextInt();
        switch(x)
        {
            case 1:
                System.out.println("poniedziałek");
                break;
            case 2:
                System.out.println("wtorek");
                break;
            case 3:
                System.out.println("środa");
                break;
            case 4:
                System.out.println("czwartek");
                break;
            case 5:
                System.out.println("piątek");
                break;
            case 6:
                System.out.println("sobota");
                break;
            case 7:
                System.out.println("niedziela");
                break;
            default:
                System.out.println("Nie ma takiego dnia");
                break;
        }
    }
}

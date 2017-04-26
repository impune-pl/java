package com.prorok.spoj;

import java.util.Scanner;
import java.lang.Math;
public class z5
{
    z5()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj równanie kwadratowe według wzoru: ax^2+bx+c, gdzie a,b,c to liczby całkowite (dodatnie lub ujemne, jeśli ujemne to zapisz np. -5x^2-5x-5) zapisane w najprostszej postaci.");
        String pattern = in.next();
        int a,b,c;
        if(pattern.contains("+")&&pattern.substring(pattern.lastIndexOf("+"),pattern.length()).matches("[+][1-9]++[0-9]*+"))
        {
            c = Integer.parseInt(pattern.substring(pattern.lastIndexOf("+"),pattern.length()));
            pattern = pattern.substring(0,pattern.lastIndexOf("+")-1);
        }
        else if(pattern.contains("-")&&pattern.substring(pattern.lastIndexOf("-"),pattern.length()).matches("[-][1-9]++[0-9]*+"))
        {
            c = Integer.parseInt(pattern.substring(pattern.lastIndexOf("-"),pattern.length()));
            pattern = pattern.substring(0,pattern.lastIndexOf("-")-1);
        }
        else
        {
            System.out.println("Error1"+ pattern);
            return;
        }
        if(pattern.contains("+")&&pattern.substring(pattern.lastIndexOf("+"),pattern.length()).matches("[+][1-9]++[0-9]*+"))
        {
            b = Integer.parseInt(pattern.substring(pattern.lastIndexOf("+"),pattern.length()));
            pattern = pattern.substring(0,pattern.lastIndexOf("+"));
        }
        else if(pattern.contains("-")&&pattern.substring(pattern.lastIndexOf("-"),pattern.length()).matches("[-][1-9]++[0-9]*+"))
        {
            b = Integer.parseInt(pattern.substring(pattern.lastIndexOf("-"),pattern.length()));
            pattern = pattern.substring(0,pattern.lastIndexOf("-"));
        }
        else
        {
            System.out.println("Error2"+ pattern);
            return;
        }
        if(pattern.substring(0,pattern.length()).matches("[1-9]++[0-9]*+x[^0-9]2"))
        {
            a = Integer.parseInt(pattern.substring(0,pattern.length()-3));
        }
        else if(pattern.substring(0,pattern.length()).matches("[-][1-9]++[0-9]*+x[^0-9]2"))
        {
            a = Integer.parseInt(pattern.substring(0,pattern.length()-3));
        }
        else
        {
            System.out.println("Error3 "+ pattern);
            return;
        }
        if(a!=0)
        {
            double delta = (b * b) - (4 * a * c);
            delta = Math.sqrt(delta);
            if(delta>0)
            {
                double x1 = (-1 * b + delta) / (2 * a);
                double x2 = (-1 * b - delta) / (2 * a);
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
            else if(delta==0)
            {
                double x = (-1*b)/(2*a);
                System.out.println("x = " + x);
            }
            else
            {
                System.out.println("brak rozwiązań w zbiorze liczb rzeczywistych");
            }
        }

    }
}

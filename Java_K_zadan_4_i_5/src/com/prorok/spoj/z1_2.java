package com.prorok.spoj;
import java.util.*;

public class z1_2
{
    z1_2()
    {
        Scanner in = new Scanner(System.in);
        int x = 2000;
        int y = 5;
        System.out.println("Podaj rok:");
        x=in.nextInt();
        System.out.println("Podaj miesiąc:");
        y=in.nextInt();
        if(y<=12&&y>0)
        {
        Calendar cal = new GregorianCalendar(x, y-1, 1);
        System.out.println("Ilość dni w podanym miesiącu podanego roku: " + cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        }
        else System.out.println("Error!!!");
    }
}

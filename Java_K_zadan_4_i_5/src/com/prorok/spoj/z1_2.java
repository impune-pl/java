package com.prorok.spoj;
import java.time.LocalDate;
import java.time.YearMonth;
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

            YearMonth month = YearMonth.of(x,y);
            System.out.println("Ilość dni w podanym miesiącu podanego roku: " +  month.lengthOfMonth());
        }
        else System.out.println("Error!!!");
    }
}

package com.prorok.spoj;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class z1_3
{
    z1_3(int x, int y, int z)
    {
        if(y>0&&y<=12&&z>0&&y%2==1&&(z<=31||y%2==0&&y!=2&&z<=30)||(y==2&&z<=29&&(x%400==0||x%100!=0&&x%4==0))||(y==2&&z<=28&&!(x%400!=0||x%100!=0&&x%4==0)))
        {
            Calendar cal = new GregorianCalendar(x,y-1,z);
            for(int n = cal.get(Calendar.MONTH)-1; n>=0;n--)
            {
                x+=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                cal.set(Calendar.MONTH,-1);
            }
            System.out.println("Od początku roku minęło "+x+z);
        }
    }
}

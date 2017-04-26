package com.prorok.spoj;

import java.time.*;

public class z1_3
{
    z1_3(int x, int y, int z)
    {
        if(y>0&&y<=12&&z>0&&((y%2==1&&z<=31)||(y%2==0&&y!=2&&z<=30)||(y==2&&z<=29&&(x%400==0||x%100!=0&&x%4==0))||(y==2&&z<=28&&!(x%400!=0||x%100!=0&&x%4==0))))
        {
            System.out.println(Period.between(LocalDate.of(x,1,1), LocalDate.of(x,y,z)).getDays()+1);
        }
    }
}

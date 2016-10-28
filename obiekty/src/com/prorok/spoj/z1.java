package com.prorok.spoj;

import java.util.Scanner;

/**
 * Created by mail-_000 on 2016-10-28.
 */
public class z1
{
    public z1()
    {
        Punkt[] punkty = new Punkt[4];
        for(int x=0; x<4; x++)
        {
            System.out.println("Punkt "+(x+1));
            punkty[x]= new Punkt();
        }
        Prostokat pierwszy = new Prostokat(punkty);
        pierwszy.drawProstokat();
    }
}

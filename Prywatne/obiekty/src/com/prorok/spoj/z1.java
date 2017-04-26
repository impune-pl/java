package com.prorok.spoj;

import java.util.Scanner;


class z1
{
    z1()
    {
        Punkt[] punkty = new Punkt[4];
        for(int x=0; x<4; x++)
        {
            System.out.println("Punkt "+(x+1));
            punkty[x]= new Punkt();
        }
        Prostokat pierwszy = new Prostokat(punkty);
        if(pierwszy.isOK())pierwszy.drawProstokat();
    }
}

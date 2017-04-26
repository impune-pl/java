package com.prorok.spoj;

import java.util.Scanner;

class z2
{
    z2()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbę całkowitą:");
        LiczbaCalkowita test = new LiczbaCalkowita(in.nextInt());
        test.wyswietlLiczbe();
        test.pobierzLiczbe();
        test.wyswietlLiczbe();
    }
}

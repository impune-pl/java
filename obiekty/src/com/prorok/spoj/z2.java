package com.prorok.spoj;

import java.util.Scanner;
/**
 * Created by mail-_000 on 2016-10-28.
 */
public class z2
{
    public z2()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbę całkowitą:");
        LiczbaCalkowita test = new LiczbaCalkowita(in.nextInt());
        test.wyswietlLiczbe();
        test.pobierzLiczbe();
        test.wyswietlLiczbe();
    }
}

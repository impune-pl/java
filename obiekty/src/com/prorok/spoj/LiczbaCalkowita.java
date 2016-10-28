package com.prorok.spoj;
import java.util.Scanner;
/**
 * Created by mail-_000 on 2016-10-28.
 */
public class LiczbaCalkowita
{
    private int liczba;
    public void wyswietlLiczbe()
    {
        System.out.println(liczba);
    }
    public void pobierzLiczbe(int nowa)
    {
        liczba = nowa;
    }
    public void pobierzLiczbe()
    {
        System.out.println("Podaj nową wartość");
        Scanner in = new Scanner(System.in);
        liczba = in.nextInt();
    }
    public LiczbaCalkowita(int nowa)
    {
        liczba = nowa;
    }
}

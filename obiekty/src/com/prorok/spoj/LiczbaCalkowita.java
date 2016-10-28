package com.prorok.spoj;
import java.util.Scanner;
class LiczbaCalkowita
{
    private int liczba;
    void wyswietlLiczbe()
    {
        System.out.println(liczba);
    }
    public void pobierzLiczbe(int nowa)
    {
        liczba = nowa;
    }
    void pobierzLiczbe()
    {
        System.out.println("Podaj nową wartość");
        Scanner in = new Scanner(System.in);
        liczba = in.nextInt();
    }
    LiczbaCalkowita(int nowa)
    {
        liczba = nowa;
    }
}

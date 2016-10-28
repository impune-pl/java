package com.prorok.spoj;
import java.util.Scanner;

class Pracownik
{
    private String imie;
    private String nazwisko;
    private int wiek;
    public void printName()
    {
        System.out.println(imie + nazwisko);
    }
    public String getName()
    {
        return (imie + nazwisko);
    }
    void printInfo()
    {
        System.out.println(imie+" " + nazwisko+" wiek: "+wiek);
    }
    public String getInfo()
    {
        return (imie +" "+ nazwisko+ " wiek: "+wiek);
    }
    Pracownik(String a, String b, int c)
    {
        imie = a;
        nazwisko = b;
        wiek = c;
    }
    Pracownik()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Imie");
        imie = in.nextLine();
        System.out.println("Nazwisko");
        nazwisko = in.nextLine();
        System.out.println("Wiek");
        wiek = in.nextInt();
    }
}

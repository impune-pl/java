package com.prorok.spoj;

import java.util.Scanner;

/**
 * Created by mail-_000 on 2016-10-28.
 */
public class z4
{
    public z4()
    {
        Pracownik[] nowi = new Pracownik[3];
        for(int x=0;x<3;x++)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Imie "+x);
            String imie = in.nextLine();
            System.out.println("Nazwisko "+x);
            String nazwisko = in.nextLine();
            System.out.println("Wiek "+x);
            int wiek = in.nextInt();
            nowi[x]= new Pracownik(imie, nazwisko, wiek);
        }
        Firma2 firemka = new Firma2(nowi);
        firemka.wyswietlInfo();
    }
}

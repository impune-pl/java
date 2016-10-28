package com.prorok.spoj;

/**
 * Created by mail-_000 on 2016-10-28.
 */
public class Firma2 extends Firma
{
    private Pracownik pracownik3;
    public Firma2(Pracownik[] nowi)
    {
        pracownik1 = nowi[0];
        pracownik2 = nowi[1];
        pracownik3 = nowi[2];
    }
    public void wyswietlInfo()
    {
        pracownik1.printInfo();
        pracownik2.printInfo();
        pracownik3.printInfo();
    }
}

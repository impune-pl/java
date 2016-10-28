package com.prorok.spoj;

/**
 * Created by mail-_000 on 2016-10-28.
 */
public class Firma
{
    protected Pracownik pracownik1;
    protected Pracownik pracownik2;
    public Firma()
    {
        pracownik2=new Pracownik();
        pracownik1=new Pracownik();
    }
    public void wyswietlInfo()
    {
        pracownik2.printInfo();
        pracownik1.printInfo();
    }
}

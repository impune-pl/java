package com.prorok.spoj;

class Firma
{
    private Pracownik pracownik1;
    private Pracownik pracownik2;
    Firma()
    {
        pracownik2=new Pracownik();
        pracownik1=new Pracownik();
    }
    void wyswietlInfo()
    {
        pracownik2.printInfo();
        pracownik1.printInfo();
    }
}

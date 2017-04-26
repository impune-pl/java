package Komunikator;

/**
 * Created by Krzysztof 'impune_pl' on 2016-11-17.
 */
public class IP
{
    private int[] octets = new int[4];

    public void setAdress(String adresIP)
    {
        //todo: dzielenie stringa na oktety, konwersja ich do int i zapis w tablicy (pętla)
    }
    public String getAdress()
    {
        String Adress="";
        int y=0;
        for (int x: octets)
        {
            Adress+=x;
            if(y<3)Adress+=".";
            y++;
        }
        return Adress;
    }
    //todo: dodatkowe ekcesory ??
}

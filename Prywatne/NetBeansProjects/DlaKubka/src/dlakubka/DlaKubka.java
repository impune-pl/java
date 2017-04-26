package dlakubka;
import java.util.*;
import java.io.File;
public class DlaKubka 
{
    public static void main(String[] args)
    {
        //w wypadku dodania argumentów:
            //1. dodać nowy string tutaj
        String fileName="config.txt";
        if(args.length > 0)
        {
            int a = args.length;
            String[] parameters = Arrays.toString(args).substring(1, Arrays.toString(args).length()-1).replaceAll(",","").split("-");
            if(parameters.length>0)
            {
                for(String element : parameters)
                {
                    System.out.println(element);
                    if(element.startsWith("f"))
                    {
                        fileName = element.replaceAll(" ", "").substring(1, element.length()-1);
                    }
                    //2. dodać warunek sprawdzający i kod wycinający treść stringa tutaj
                }
            }
        }
        File f = new File("\\."+fileName);
        // Struktura pliku (każdy element w nowej linii)
        // 1. etykieta początku bloku !ACTION
        // 2. komenda, według wzoru - !COMMAND<komenda> (z nawiasami ostrymi)
        // 3. zasięg adresów ip, na początek z maską 255.255.255.0 według wzoru !FADRESS<pierwszy adres>!LADDRESS<ostatni adres> (z nawiasami ostrymi)
        // 4. port ssh - tylko jeśli inny niż 22, wg wzoru !PORT<numer portu> (z nawiasami ostrymi)
        // 5. username konta na które ma się zalogować ssh, wg wzoru !ANAME<username> (z nawiasami ostrymi)
        // 6. hasło konta na które ma się zalogować ssh - przewiduję pracę nad obsługą kluczy i szyfrowaniem haseł !PASSWORD<hasło> (z nawiasami ostrymi)
        // TODO: inne opcje
        // Blok kończy się znacznikiem !END
        
    }
    
}

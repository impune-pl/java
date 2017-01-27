package Komunikator;

/**
 * Created by Krzysztof 'impune_pl' on 2016-11-09.
 */
public class User
{
    private String username;
    private IP adress = new IP();
    public void User(String username, IP adress)
    {
        this.username = username;
        this.adress = adress;
    }
}

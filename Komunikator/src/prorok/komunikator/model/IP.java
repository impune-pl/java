package prorok.komunikator.model;

/**
 * Created by Krzysztof 'impune_pl' on 2017-01-27.
 */
public class IP
{
    private String address;
    public IP(String address)
    {
            this.address=address;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
}

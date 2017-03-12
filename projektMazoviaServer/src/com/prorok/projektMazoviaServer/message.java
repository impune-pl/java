package com.prorok.projektMazoviaServer;

/**
 * Created by Krzysztof 'impune_pl' on 2017-03-12.
 */
public class message
{
    private String text;
    private String owner;
    public message(String text, String owner)
    {
        this.text = text;
        this.owner = owner;
    }
    public String getText()
    {
        return text;
    }

    public String getOwner()
    {
        return owner;
    }
}

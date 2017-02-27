package prorok.komunikator.model;



/**
 * Created by Krzysztof 'impune_pl' on 2017-01-18.
 */
public class Message
{
    private String content;
    private String source;
    public Message(String content, String source)
    {
        this.content = content;
        this.source = source;
    }
    public String getContent()
    {
        return content;
    }
    public String getSource()
    {
        return source;
    }
}

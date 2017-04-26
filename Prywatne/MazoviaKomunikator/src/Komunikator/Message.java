package Komunikator;

/**
 * Created by Krzysztof 'impune_pl' on 2016-11-09.
 */
public class Message
{
    private User Recipent;
    private String MessageText;
    public void Message(User Recipent, String MessageText)
    {
        this.Recipent = Recipent;
        this.MessageText = MessageText;
    }
    public void Send()
    {
        //TODO: umieszczenie wiadomości w buforze wysyłanych
    }
}

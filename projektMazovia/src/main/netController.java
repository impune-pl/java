package main;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class netController implements Runnable
{
    private String ip;
    private Socket socket;
    private ServerSocket serverSocket;
    private boolean connected;
    final ArrayBlockingQueue<String> ipChanges;
    ArrayBlockingQueue<message> toSend;
    ArrayBlockingQueue<message> toDisplay;
    DataOutputStream sender;
    public netController(ArrayBlockingQueue<String> alfa,ArrayBlockingQueue<message> beta, ArrayBlockingQueue<message> gamma)
    {
        ipChanges = alfa;
        toSend = beta;
        toDisplay = gamma;
    }
    public void run()
    {
        try
        {
            serverSocket = new ServerSocket(5161);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        while (!Thread.currentThread().isInterrupted())
            {
                serverSocket.
                if(ipChanges.contains("1"))
                {
                    try
                    {
                        try
                        {
                            sender.close();
                        }
                        catch(IOException e)
                        {
                            e.printStackTrace();
                        }
                        ipChanges.remove("1");
                        socket = new Socket(ipChanges.poll(), 6666);
                        sender = new DataOutputStream(socket.getOutputStream());
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(!toSend.isEmpty())
                {
                    try
                    {
                        sender.writeUTF(toSend.poll().getText());
                        sender.flush();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if()
                //TODO: dodać obsługę server socket (odbieranie połączenia) | dokończyć obsługę nawiązywania połączenia | dodać odbiór i wysyłkę wiadomości

            }
    }
}

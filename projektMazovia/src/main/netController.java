package main;
import java.io.IOException;
import java.io.InterruptedIOException;
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
    public netController(ArrayBlockingQueue<String> alfa,ArrayBlockingQueue<message> beta, ArrayBlockingQueue<message> gamma)
    {
        ipChanges = alfa;
        toSend = beta;
        toDisplay = gamma;
    }
    public void run()
    {
            while (!Thread.currentThread().isInterrupted())
            {
                if(ipChanges.contains("1"))
                {
                    try
                    {
                        ipChanges.remove("1");
                        socket = new Socket(ipChanges.poll(), 6666);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                //TODO: dodać obsługę server socket (odbieranie połączenia) | dokończyć obsługę nawiązywania połączenia | dodać odbiór i wysyłkę wiadomości

            }
    }
}

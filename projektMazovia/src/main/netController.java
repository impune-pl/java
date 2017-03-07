package main;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class netController implements Runnable
{
    private Socket socket;
    private String serverIp;
    final ArrayBlockingQueue<String> ipChanges;
    ArrayBlockingQueue<message> toSend;
    ArrayBlockingQueue<message> toDisplay;
    DataOutputStream sender;
    DataInputStream receiver;
    public netController(ArrayBlockingQueue<String> alfa,ArrayBlockingQueue<message> beta, ArrayBlockingQueue<message> gamma, String ip)
    {
        ipChanges = alfa;
        toSend = beta;
        toDisplay = gamma;
        serverIp = ip;
    }
    public void run()
    {
        try
        {
            socket = new Socket(serverIp, 5161);
            sender = new DataOutputStream(socket.getOutputStream());
            receiver = new DataInputStream(socket.getInputStream());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        while (!Thread.currentThread().isInterrupted())
            {
                if(!toSend.isEmpty())
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
                if(ipChanges.contains("1"))
                {
                    try
                    {
                        sender.writeUTF("IPCHANGE" + ipChanges.poll());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                try
                {
                    String a = receiver.readUTF();
                    toDisplay.add(new message(a));
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
    }
}

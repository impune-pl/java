package main;
import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ArrayBlockingQueue;

public class netController implements Runnable
{
    private Socket socket;
    private String serverIp;
    private ArrayBlockingQueue<message> toSend;
    private ArrayBlockingQueue<message> toDisplay;
    DataOutputStream sender;
    DataInputStream receiver;
    public netController(ArrayBlockingQueue<message> outcoming, ArrayBlockingQueue<message> incoming, String ip)
    {
        toSend = outcoming;
        toDisplay = incoming;
        serverIp = ip;
    }
    public void run()
    {
        try
        {
            socket = new Socket(serverIp, 5161);
            System.out.println("CONNECTION ESTABLISHED");
            sender = new DataOutputStream(socket.getOutputStream());
            receiver = new DataInputStream(socket.getInputStream());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        while (true)
        {
                if(toSend.peek()!=null)
                {
                    try
                    {
                        System.out.println("SENDING");
                        try
                        {
                            sender.writeUTF(toSend.poll(2L, TimeUnit.MILLISECONDS).getText());
                        } catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                        sender.flush();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                try
                {
                    String a = receiver.readUTF();
                    try
                    {
                        toDisplay.offer(new message(a),2L,TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }
    }
}

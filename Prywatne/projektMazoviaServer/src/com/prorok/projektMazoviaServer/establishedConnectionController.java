package com.prorok.projektMazoviaServer;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Krzysztof 'impune_pl' on 2017-03-12.
 */
public class establishedConnectionController implements Runnable
{
    private Socket cSocket;
    private String ip;
    final ArrayBlockingQueue<message> messageList;
    DataInputStream in;
    DataOutputStream out;
    establishedConnectionController(String ipadd, Socket ncSocket, ArrayBlockingQueue<message> messageList)
    {
        cSocket = ncSocket;
        ip = ipadd;
        this.messageList = messageList;
        System.out.println("CONNECTION ESTABLISHED");
        try
        {
            in = new DataInputStream(ncSocket.getInputStream());
            out = new DataOutputStream(ncSocket.getOutputStream());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void run()
    {
        String lastSent="";
        while(true)
        {
            String a="";
            try
            {
                a = in.readUTF();
                System.out.println(a);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            if(a.length()>0)
            {
                messageList.add(new message(a, ip));
            }
            if(!messageList.peek().getOwner().equals(ip)&&!messageList.peek().getText().equals(lastSent))
            {
                lastSent = messageList.peek().getText();
                try
                {
                    out.writeUTF(lastSent);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}

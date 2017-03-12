package com.prorok.projektMazoviaServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Krzysztof 'impune_pl' on 2017-03-12.
 */
public class incomingConnectionController implements Runnable
{
    private boolean isStopped = false;
    private ServerSocket sScoket;
    private Socket cSocket;
    final ArrayBlockingQueue<message> messageList = new ArrayBlockingQueue<>(200);
    public incomingConnectionController()
    {
        try
        {
            sScoket = new ServerSocket(5161);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            isStopped = true;
        }
    }
    public void run()
    {
        while(!isStopped)
        {
            cSocket = null;
            try
            {
                cSocket = sScoket.accept();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            establishedConnectionController newConnection = new establishedConnectionController(cSocket.getInetAddress().toString(), cSocket, messageList);
            new Thread(newConnection).start();
            if(messageList.remainingCapacity()==0)
            {
                messageList.clear();
            }
        }
    }
}

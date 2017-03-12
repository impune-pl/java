package com.prorok.projektMazoviaServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Krzysztof 'impune_pl' on 2017-03-12.
 */
public class incomingConnectionController implements Runnable
{
    private boolean isStopped = false;
    private ServerSocket sScoket;
    private Socket cSocket;
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

        }
    }
}

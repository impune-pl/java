package com.prorok.projektMazoviaServer;

import java.net.Socket;

/**
 * Created by Krzysztof 'impune_pl' on 2017-03-12.
 */
public class establishedConnectionController implements Runnable
{
    private Socket cSocket;
    private String ip;
    establishedConnectionController(String ipadd, Socket ncSocket)
    {
        cSocket = ncSocket;
        ip = ipadd;
    }
    public void run()
    {

    }
}

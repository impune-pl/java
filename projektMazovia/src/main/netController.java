package main;
import java.net.*;
import java.util.*;
public class netController
{
    public netController()
    {
        try
        {
            ServerSocket newConnectionListener = new ServerSocket(8585);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

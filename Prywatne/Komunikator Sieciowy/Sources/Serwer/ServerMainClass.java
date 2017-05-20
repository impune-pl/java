package ServerMain;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;

public class ServerMainClass
{
    private static HashSet<String> Names = new HashSet<>();
    private static HashSet<String> UserNames = new HashSet<>();
    private static HashSet<PrintWriter> ClientOutputList = new HashSet<>();
    private static int ConnectionAmount = 0;
    private static String AdminName="";

    public static void main(String[] args)
    {
        System.out.println("Welcome to your Server. It can handle up to 32 users now." +
                "\nPlease choose admin username." +
                "\n(admin is a user who can use commands to kick other users*)" +
                "\nThe first user to connect with username of your choice will become admin"+
                "\nAdmin can use '/DISCONNECT [USERNAME]' command to kick users"+
                "\n*More commands may be added later.");
        Scanner in = new Scanner(System.in);
        while(AdminName.trim().length()<1)AdminName = in.nextLine();
        System.out.print("Thank you." +
                "\nThe server is starting up now.\n");
        try
        {
            ServerSocket chatServer = new ServerSocket(5161);
            while (true)
            {
                Socket socket = chatServer.accept();
                new ClientConnection(socket).start();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static class ClientConnection extends Thread
    {
        private String UserName;
        private String ServerSimplifiedName;
        private Socket Connection;
        private BufferedReader in;
        private PrintWriter out;

        public ClientConnection(Socket socket)
        {
            this.Connection = socket;
        }

        @Override
        public void run()
        {
            try
            {
                in = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
                out = new PrintWriter(Connection.getOutputStream(), true);

                UserName = in.readLine();
                ServerSimplifiedName = UserName.toLowerCase();

                synchronized (Names)
                {
                    while (Names.contains(ServerSimplifiedName) || UserName == null || UserName.trim().isEmpty())
                    {
                        out.println("CHANGEUSERNAME");
                        UserName = in.readLine();
                        ServerSimplifiedName = UserName.toLowerCase();
                    }
                }
                out.println("USERNAMEACCEPTED");

                System.out.println("New user connected: "+UserName+" IP: "+Connection.getInetAddress().getHostAddress());

                SendToAll("CONNECTED" + UserName);
                UserNames.add(UserName);
                Names.add(ServerSimplifiedName);
                ClientOutputList.add(out);

                ConnectionAmount++;

                while (true)
                {
                    String input = in.readLine();

                    if (input == null || input.isEmpty())
                    {
                        continue;
                    }
                    if(input.startsWith(AdminName+": /DISCONNECT")&& UserName.equals(AdminName))
                    {
                        SendCommandToAll(input.substring(AdminName.length()+2));
                    }
                    else SendToAll("MESSAGE " + input);
                    if(Thread.currentThread().isInterrupted())
                    {
                        Connection.close();
                        break;
                    }
                }
            }
            catch (IOException e)
            {
                if (UserName != null)
                {
                    System.out.println(UserName + " disconnected.");
                    UserNames.remove(UserName);
                    Names.remove(ServerSimplifiedName);
                    ClientOutputList.remove(out);
                    SendToAll("DISCONNECTED" + UserName);
                    ConnectionAmount--;
                }
            }
            finally
            {
                try
                {
                    Connection.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void SendToAll(String... messages)
    {
        if (!ClientOutputList.isEmpty())
        {
            for (String message : messages)
            {
                for (PrintWriter writer : ClientOutputList)
                {
                    writer.println(message);
                }
            }
        }
    }
    private static void SendCommandToAll(String... messages)
    {
        if (!ClientOutputList.isEmpty())
        {
            for (String message : messages)
            {
                for (PrintWriter writer : ClientOutputList)
                {
                    writer.println(message);
                }
            }
        }
    }
}
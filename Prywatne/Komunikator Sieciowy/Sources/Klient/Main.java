package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Optional;

public class Main extends Application
{
    private final int port = 5161;
    private String serverAddress = "127.0.0.1";
    private String userName = "Anonymous";
    PrintWriter sender;
    BufferedReader receiver;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        TextArea messageArea = new TextArea();
        messageArea.setEditable(false);

        TextField textField = new TextField();
        textField.setEditable(true);
        textField.setOnKeyPressed(ke ->
        {
            if (ke.getCode().equals(KeyCode.ENTER))
            {
                sender.println(userName + ": " +textField.getText());
                textField.clear();
            }
        });

        VBox layout = new VBox(5);
        layout.getChildren().addAll(messageArea, textField);
        primaryStage.setScene(new Scene(layout));
        primaryStage.setTitle("Projekt Mazovia 2016/17 by Krzysztof Prorok");

        getServerAddress();
        getUserName();

        Task netControlTask = new Task()
        {
            @Override
            public Void call()
            {
                Socket socket;
                int trys =0;
                try
                {
                    while(true)
                    {
                        try
                        {
                            socket = new Socket(serverAddress, port);
                            break;
                        }
                        catch (Exception e)
                        {
                            messageArea.appendText("CONNECTION FAILED"+'\n');
                            trys++;
                            if(trys%3 == 0)
                            {
                                Platform.exit();
                                System.exit(0);
                            }
                        }
                    }
                    messageArea.appendText("CONNECTION ESTABLISHED"+'\n');
                    sender = new PrintWriter(socket.getOutputStream(), true);
                    receiver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while(true)
                    {
                        sender.println(userName);
                        String a = receiver.readLine();
                        if(a.startsWith("CHANGEUSERNAME"))
                        {
                            messageArea.appendText("Wrong username, type another username and press \'enter\'"+'\n');
                        }
                        else if(a.startsWith("USERNAMEACCEPTED"))break;
                    }
                    while(true)
                    {
                            String incoming = receiver.readLine();
                            if(incoming.startsWith("/DISCONNECT "+userName))
                            {
                                sender.close();
                                receiver.close();
                                socket.close();
                                messageArea.appendText("CONNECTION CLOSED BY SERVER"+'\n'+"APPLICATION CLOSING");
                                Thread.sleep(1500);
                                Platform.exit();
                                System.exit(0);
                            }
                            else if(incoming.startsWith("MESSAGE"))
                            {
                                messageArea.appendText(incoming.substring(8) + '\n');
                            }
                            else if(incoming.startsWith("CONNECTED"))
                            {
                                messageArea.appendText(incoming.substring(9) + " is now connected." + '\n');
                            }
                            else if(incoming.startsWith("DISCONNECTED"))
                            {
                                messageArea.appendText(incoming.substring(12) + " just left." + '\n');
                            }
                        }
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                return null;
            }
        };
        Thread netController = new Thread(netControlTask);
        netController.setDaemon(true);
        netController.start();
        primaryStage.show();
    }

    private void getUserName()
    {
            TextInputDialog dialog = new TextInputDialog("Anonymous");
            dialog.setTitle("Enter your Username");
            dialog.setHeaderText("Enter your Username");
            dialog.setContentText("Enter your Username: ");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(name -> userName = result.get());
    }

    private void getServerAddress()
    {
        do
        {
            TextInputDialog dialog = new TextInputDialog("127.0.0.1");
            dialog.setTitle("Establishing Connection");
            dialog.setHeaderText("Establishing Connection");
            dialog.setContentText("Enter server address: ");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(name -> serverAddress = result.get());
        }while(!IpValidation.isIPv4Address(serverAddress));
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

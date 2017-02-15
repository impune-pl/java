package main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.net.*;
import java.util.ResourceBundle;
import java.util.concurrent.*;

import main.netController;

public class Controller implements Initializable
{
    @FXML
    private ListView<?> messangeList;

    @FXML
    private Button sendButton;

    @FXML
    private TextField messengeField;

    @FXML
    private TextField ipInput;

    @FXML
    private Button connectButton;
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        final ArrayBlockingQueue<message> toSend = new ArrayBlockingQueue<>(20);
        final ArrayBlockingQueue<message> toDisplay = new ArrayBlockingQueue<>(20);
        final ArrayBlockingQueue<String> ipChange = new ArrayBlockingQueue<>(2);
        Runnable netControlRunnable = new netController(ipChange, toSend, toDisplay);
        Thread netControl = new Thread(netControlRunnable);
        netControl.start();
        sendButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                String mContent = messengeField.getText();
                if(mContent.trim().equals(""))
                {
                    //TODO: wypisanie okienka "błąd, brak tekstu wiadomości;
                }
                else
                {
                    message newMessage = new message(mContent);
                    toSend.add(newMessage);
                }
            }
        });
        connectButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if(IpValidation.isIp(ipInput.getText()))
                {
                    ipChange.add("1");
                    ipChange.add(ipInput.getText());
                }
                else
                {
                    //TODO: komunikat o błędnym ip;
                }
            }
        });
        //TODO: observablelist do którego będą dodawane wiadomości z toDisplay, event odpowiedzialny za dodawanie tych wiadomości i drugi event do czyszczenia wyświetlonych wiadomości
    }

}

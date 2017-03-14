package main;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.net.*;
import java.util.ResourceBundle;
import java.util.concurrent.*;
import javafx.beans.property.*;

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
    private final ObservableList Displayed= FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        String serverIp = "127.0.0.1";//TODO: pobieranie za pomocą dialogu!!!!

        ArrayBlockingQueue<message> toSend = new ArrayBlockingQueue<>(20);
        ArrayBlockingQueue<message> toDisplay = new ArrayBlockingQueue<>(20);

        Runnable netControlRunnable = new netController(toSend, toDisplay, serverIp);
        Thread netControl = new Thread(netControlRunnable);
        netControl.start();

        messangeList.setItems(Displayed);
        sendButton.setOnAction(event ->
        {
            String mContent = messengeField.getText();
            if(mContent.trim().equals(""))
            {}
            else
            {
                if(toSend.remainingCapacity()==0)
                {
                    toSend.clear();
                }
                message newMessage = new message(mContent);
                System.out.println("new message "+mContent);
                try
                {
                    toSend.offer(newMessage, 2L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                Displayed.add("me: "+newMessage.getText());
            }
        });
        final LongProperty LastUpdate = new SimpleLongProperty();
        final long minUpdateInterval = 0 ;
        AnimationTimer timer = new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                if(now - LastUpdate.get() > minUpdateInterval)
                {
                    while(!toDisplay.isEmpty())
                    {
                        try
                        {
                            Displayed.add("Other: "+toDisplay.take().getText());
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
                LastUpdate.set(now);
            }
        };
        timer.start();
        //TODO: dialog pobierający ip serwera -- WAŻNE!!!!!!!!!!!!!!!!!

    }

}

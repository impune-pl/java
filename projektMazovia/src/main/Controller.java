package main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

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
        sendButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                //TODO: wysyłanie wiadomości z pola tekstowego
            }
        });
        connectButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                //TODO: inicjowanie połączenia z adresem docelowym
            }
        });
    }

}

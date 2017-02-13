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
        netController mainNetController = new netController();

        sendButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                String mContent = messengeField.getText();
                if(mContent.equals(""))
                {
                    //TODO: wypisanie okienka "błąd, brak tekstu wiadomości;
                }
                else
                {
                    //TODO: stworzenie i wysłanie wiadomości przez TCP przy użyciu netController
                }
            }
        });
        connectButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                //TODO: inicjowanie połączenia z adresem docelowym poprzez wysłanie "hello" w TCP
            }
        });
    }

}

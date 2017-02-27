package prorok.komunikator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import prorok.komunikator.model.Message;

import java.io.IOException;

/**
 * Created by Krzysztof 'impune_pl' on 2017-01-11.
 */
public class Main extends Application
{

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Message> MessageList = FXCollections.observableArrayList();
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");
        this.primaryStage.setMinHeight(430);
        this.primaryStage.setMaxHeight(430);
        this.primaryStage.setMinWidth(600);
        this.primaryStage.setMaxWidth(600);
        initializeMainLayout();
        showGUI();
    }

    public void initializeMainLayout()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("mainWindow.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showGUI()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("mainView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(personOverview);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

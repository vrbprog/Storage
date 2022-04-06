import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.Client;

import java.io.IOException;
import java.net.ConnectException;

public class MainApp extends Application {

    private Stage primaryStage;
    private MainController mainController;
    private ConnectController connectController;
    private LoginController loginController;
    private Client client;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        if(checkServerConnect()){
            ShowLoginView();
        } else {
            ShowConnectView();
        }

    }

    private boolean checkServerConnect() {
        try {
            client = new Client();
            return true;
        } catch (ConnectException e){
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void ShowConnectView() throws IOException {
        // Получение контроллера главного вида
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("fxml/connectView.fxml"));
        AnchorPane pane = loader.load(); // Необходим для инициализации loader и дальнейшего получения контроллера
        connectController = loader.getController();

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Connection");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void ShowLoginView() throws IOException {
        // Получение контроллера главного вида
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("fxml/loginView.fxml"));
        AnchorPane pane = loader.load(); // Необходим для инициализации loader и дальнейшего получения контроллера
        loginController = loader.getController();
        loginController.setClient(client);
        loginController.clientExit();

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


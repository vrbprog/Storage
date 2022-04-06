import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static MainController mainController;

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Получение контроллера главного вида
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("fxml/mainView.fxml"));
        loader.load(); // Необходим для инициализации loader и дальнейшего получения контроллера
        mainController = loader.getController();

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("fxml/mainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Storage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


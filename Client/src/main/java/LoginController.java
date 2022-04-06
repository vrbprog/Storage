import javafx.fxml.Initializable;
import net.Client;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Client client;

    public void setClient(Client client){
        this.client = client;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void clientExit(){
        client.DisconnectServer();
    }
}

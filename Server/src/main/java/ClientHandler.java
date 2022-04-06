import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private String userName;


    public ClientHandler(Socket socket) {
        clientSocket = socket;
    }

    @Override
    public void run() {
        boolean isConnecting = true;
        System.out.println(isConnecting);
        try (DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
             DataInputStream in = new DataInputStream(clientSocket.getInputStream())) {
             System.out.println("Run Thread of client");
            while (isConnecting){
                String command = in.readUTF();
                switch (command){
                    case "req_connect": {
                        System.out.println("Connecting with client");
                        out.writeUTF("connect_done");
                        break;
                    }
                    case "req_disconnect": {
                        System.out.println("Disconnecting with client");
                        out.writeUTF("disconnect_done");
                        isConnecting = false;
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

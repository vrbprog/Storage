package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private final Socket clientSocket;
    private final DataInputStream in;
    private final DataOutputStream out;

    public Client() throws IOException {
        clientSocket = new Socket("localhost", 2001);
        in = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());
    }

    public  String ConnectServer(){
        String answer = "";
        try {
            out.writeUTF("req_connect");
            answer = in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    public String DisconnectServer(){
        String answer = "";
        try {
            out.writeUTF("req_disconnect");
            answer = in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }
}

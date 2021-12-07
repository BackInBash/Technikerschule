package its.de.fti;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ChatClient {

    private final String username;
    private final String serverIP;
    private final int serverPort;
    private ServerListener serverListener;

    public ChatClient(String username, String serverIP, int serverPort) throws IOException {
        this.username = username;
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void loginToServer() throws IOException {
        // in einem eigenen Thread auf den Server hören
        serverListener = new ServerListener(username, 4713);
        new Thread(serverListener).start();

        //Send Message Login
        Socket socket = new Socket(serverIP, serverPort);
        OutputStream outLogin = socket.getOutputStream();
        String sendMessage = Wrapper.wrap("login", username);
        byte[] buffer = sendMessage.getBytes();
        outLogin.write(buffer);
        outLogin.close();
        socket.close();
    }

    public void logoutFromServer() throws IOException {
        // Thread stoppen
        serverListener.setListenToServer(false);

        //Send Message Logout
        Socket socket = new Socket(serverIP, serverPort);
        OutputStream outLogin = socket.getOutputStream();
        String sendMessage = Wrapper.wrap("logout", username);
        byte[] buffer = sendMessage.getBytes();
        outLogin.write(buffer);
        outLogin.close();
        socket.close();
    }

    public void send(String text) throws IOException {
        //Send Message 
        Socket socket = new Socket(serverIP, serverPort);
        OutputStream outMessage = socket.getOutputStream();
        String sendMessage = Wrapper.wrap("message", text);
        byte[] buffer = sendMessage.getBytes();
        outMessage.write(buffer);
        outMessage.close();
        socket.close();
    }
}

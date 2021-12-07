package its.de.fti;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerListener implements Runnable {

    private boolean listenToServer;
    private final String username;
    private final int serverPort;
    private ServerSocket serverSocket;

    public ServerListener(String username, int serverPort) throws IOException {
        this.username = username;
        this.serverPort = serverPort;
        openListeningServer();
    }

    public boolean isListenToServer() {
        return listenToServer;
    }

    public void setListenToServer(boolean listenToServer) {
        this.listenToServer = listenToServer;
    }

    private void openListeningServer() throws IOException {
        serverSocket = new ServerSocket(serverPort);
        listenToServer = true;
    }

    @Override
    public void run() {
        while (listenToServer) {
            try {
                Socket client = serverSocket.accept();// Server wartet auf Client(s)

                //Receive Message from Client
                InputStream receiveMessage = client.getInputStream();
                byte[] receiveBuffer = new byte[1000];
                int numberOfReceivesBytes = receiveMessage.read(receiveBuffer);
                String strReceiveMessage = new String(receiveBuffer, 0, numberOfReceivesBytes);
                receiveMessage.close();

                if (strReceiveMessage.contains("<message>")) {
                    String message = Wrapper.deWrap("message", strReceiveMessage);
//                    if (!message.startsWith(username)) {
                        System.out.println("Message from client: " + message);
//                    }
                    client.close();
                } else if (strReceiveMessage.contains("<logout>")) {
                    String message = Wrapper.deWrap("message", strReceiveMessage);
                    System.out.println(message);
                    client.close();
                }
            } catch (IOException ex) {
                listenToServer = false; // Thread stoppen
            }
        }
        try {
            serverSocket.close(); // Server stoppen
        } catch (IOException ex) {
            Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

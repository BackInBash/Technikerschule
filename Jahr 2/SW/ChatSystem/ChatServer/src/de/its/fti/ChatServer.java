package de.its.fti;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextArea;

class ChatServer implements Runnable {

    private final JTextArea txaMessages;
    private final ServerSocket serverSocket;
    private boolean isServerListen = false;
    private final ArrayList<Client> clientsList = new ArrayList<>();

    public ChatServer(JTextArea txa_Messages) throws IOException {
        this.txaMessages = txa_Messages;
        serverSocket = new ServerSocket(4712);  // Server hört auf Port 4712
        isServerListen = true;
        this.txaMessages.append("- Server initialized\n");
    }

    public void close() throws IOException {
        if (!serverSocket.isClosed()) {
            isServerListen = false;
            serverSocket.close();
        }
    }

    @Override
    public void run() {
        Client client;
        while (isServerListen) {
            try {
                this.txaMessages.append("- Server is waiting for incomming connection\n");

                Socket clientSocket = serverSocket.accept();// Server wartet auf sich anmeldende Client(s)

                //Receive Message from Client
                InputStream receiveMessage = clientSocket.getInputStream();
                byte[] receiveBuffer = new byte[1000];
                int numberOfReceivesBytes = receiveMessage.read(receiveBuffer);
                String strReceiveMessage = new String(receiveBuffer, 0, numberOfReceivesBytes);
                receiveMessage.close();

                client = null;

                if (strReceiveMessage.contains("<login>")) {
                    client = new Client(clientSocket, Wrapper.deWrap("login", strReceiveMessage));
                    clientsList.add(client);
                    txaMessages.append("- Client " + client.getSocket().getInetAddress().toString() + " connected to Server\n");
                    txaMessages.append("- Client: " + client.getName() + " --> Login\n");
                    clientSocket.close();
                } else if (strReceiveMessage.contains("<message>")) {
                    // Sender in der Liste finden
                    for (Client tmpClient : clientsList) {
                        if (tmpClient.getSocket().getInetAddress().getHostAddress().equalsIgnoreCase(clientSocket.getInetAddress().getHostAddress())) {
                            client = tmpClient;
                        }
                    }
                    clientSocket.close();

                    // nur angemeldete Clients dürfen Nachrichten senden
                    if (client != null) {
                        txaMessages.append(String.format("- Client[%s] Message: %s\n", client.getSocket().getInetAddress(), Wrapper.deWrap("message", strReceiveMessage)));
                        String message = "<message>" + client.getName() + ":" + Wrapper.deWrap("message", strReceiveMessage) + "</message>";
                        for (Client tmpClient : clientsList) {
                            Socket socket = new Socket(tmpClient.getSocket().getInetAddress(), 4713);
                            OutputStream outMessage = socket.getOutputStream();
                            byte[] sendBuffer = message.getBytes();
                            outMessage.write(sendBuffer);
                            outMessage.close();
                            socket.close();
                        }
                    }
                } else if (strReceiveMessage.contains("<logout>")) {
                    // Sender in der Liste finden
                    for (Client tmpClient : clientsList) {
                        if (tmpClient.getSocket().getInetAddress().getHostAddress().equalsIgnoreCase(clientSocket.getInetAddress().getHostAddress())) {
                            client = tmpClient;
                        }
                    }
                    clientSocket.close();

                    // nur angemeldete Clients dürfen sich abmelden
                    if (client != null) {
                        txaMessages.append("- Client " + client.getSocket().getInetAddress().toString() + " goes offline\n");

                        // Client aus Liste entfernen
                        Iterator<Client> itClientList = clientsList.iterator();

                        boolean isClientFound = false;
                        while (!isClientFound && itClientList.hasNext()) {
                            Client nextClient = itClientList.next();
                            if (client.getSocket().getInetAddress().equals(nextClient.getSocket().getInetAddress())) {
                                itClientList.remove();
                                isClientFound = true;
                            }
                        }
                        
                        txaMessages.append("- Client: " + client.getName() + " --> Logged out\n");
                        String message = "<logout>- Client: " + client.getName() + " --> offline</logout>";
                        // alle Clients informieren
                        for (Client tmpClient : clientsList) {
                            Socket socket = new Socket(tmpClient.getSocket().getInetAddress(), 4713);
                            OutputStream outMessageLogout = socket.getOutputStream();
                            byte[] sendBuffer = message.getBytes();
                            outMessageLogout.write(sendBuffer);
                            socket.close();
                        }
                    }
                }

            } catch (IOException ex) {
                txaMessages.append("- IO-Error occured - " + ex.getMessage() + "\n");
                isServerListen = false;
            }
        }
    }
}

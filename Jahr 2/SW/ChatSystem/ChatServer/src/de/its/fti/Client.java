package de.its.fti;

import java.net.Socket;

public class Client {

    private final Socket socket;
    private final String name;

    public Client(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getName() {
        return name;
    }
}

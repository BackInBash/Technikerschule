import com.hivemq.client.internal.mqtt.message.auth.MqttSimpleAuth;
import com.hivemq.client.mqtt.MqttGlobalPublishFilter;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;
import com.hivemq.client.mqtt.mqtt5.message.auth.Mqtt5SimpleAuth;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;
import org.omg.PortableServer.POA;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class MQTTPub {

    public Mqtt5BlockingClient client;
    private MqttSimpleAuth auth;
    private String Server;
    private String ClientID;
    private int Port;

    public MQTTPub(String Server, int Port, String ClientID){
        this.Server = Server;
        this.ClientID = ClientID;
        this.Port = Port;
    }

    public void Configure(){

    }

    public void Connect(){
        client = Mqtt5Client.builder()
                .identifier(ClientID)
                .serverHost(Server)
                .serverPort(Port)
                .buildBlocking();
        client.connect();
    }

    public void ConnectwithCreds(String username, String password){
        Mqtt5SimpleAuth simpleAuth = Mqtt5SimpleAuth.builder()
                .username(username)
                .password(password.getBytes())
                .build();

        client = Mqtt5Client.builder()
                .identifier(ClientID)
                .serverHost(Server)
                .serverPort(Port)
                .simpleAuth(simpleAuth)
                .buildBlocking();

        client.connect();
    }

    public void Disconnect(){
        client.disconnect();
    }

    public void Listening(String Topic){
        try (Mqtt5BlockingClient.Mqtt5Publishes publishes = client.publishes(MqttGlobalPublishFilter.ALL)) {
            Mqtt5Publish publishMessage = publishes.receive();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void SendMessage(String message, String Topic){
        client.publishWith().topic(Topic).qos(MqttQos.AT_LEAST_ONCE).payload(message.getBytes()).send();
    }
}
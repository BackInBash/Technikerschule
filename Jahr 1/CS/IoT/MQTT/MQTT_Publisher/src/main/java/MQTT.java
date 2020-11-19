import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;

public class MQTT {

    public Mqtt5BlockingClient client;
    private String Server;
    private String ClientID;

    public MQTT(String Server, String ClientID){
        this.Server = Server;
        this.ClientID = ClientID;
        Configure();
    }

    public void Configure(){
       client = Mqtt5Client.builder()
                .identifier(ClientID)
                .serverHost(Server)
                .buildBlocking();
    }

    public void Connect(){
        client.connect();
    }

    public void Disconnect(){
        client.disconnect();
    }

    public void SendMessage(String message, String Topic){
        client.publishWith().topic(Topic).qos(MqttQos.AT_LEAST_ONCE).payload(message.getBytes()).send();
    }
}

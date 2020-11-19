import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;

public class main {

    public static void main(String[] args){
        System.out.println("");

        MQTT client = new MQTT("broker.hivemq.com", "HelpFromJava");
        client.Connect();
        for(;;) {
            client.SendMessage("test", "FTI1");
        }
    }
}
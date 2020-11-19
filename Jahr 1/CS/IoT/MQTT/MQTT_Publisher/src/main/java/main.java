import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;

public class main {

    public static void PrintHelp(){
        System.out.println("MQTT Client <3\n" +
                "   --flood     GTFO\n" +
                "   --server    Server Address\n" +
                "   --port      Server Port\n" +
                "   --topic     MQTT Topic\n" +
                "   --ClientID  MQTT Client ID\n" +
                "   --message   MQTT Message\n" +
                "   --listening MQTT Listener");
    }

    public static void main(String[] args) throws InterruptedException {

        // Set Vars
        boolean flood = false;
        String Server = "";
        int Port = 1883;
        String Topic = null;
        String ClientID = "HeloFromJava";
        String Message = "";
        boolean isListener = false;

        // Parse CLI Args
        for (int i = 0; i < args.length - 1; i++) {
            switch (args[i]) {
                case "--flood":
                    flood = true;
                    break;
                case "--server":
                    Server = args[i + 1];
                    break;
                case "--port":
                    Port = Integer.parseInt(args[i + 1]);
                    break;
                case "--topic":
                    Topic = args[i + 1];
                    break;
                case "--ClientID":
                    ClientID = args[i + 1];
                    break;
                case "--message":
                    Message = args[i + 1];
                    break;
                case "--listening":
                    isListener = true;
            }
        }

        // Check User Input
        if(args.length == 0){
            PrintHelp();
            return;
        }
        if(Server.isEmpty() && Message.isEmpty()){
            System.out.println("ERROR!!!!");
            PrintHelp();
            return;
        }

        // Create MQTT Client
        MQTTPub client = new MQTTPub(Server, Port, ClientID);
        // Connect to Server
        client.Connect();

        // Starting Flood
        if(flood){
            for(;;) {
                client.SendMessage(Message, Topic);
            }
        }

        // Start Listener
        if(isListener){
            MQTTSub subClient = new MQTTSub(Server, Port, ClientID);
            client.Listening(Topic);
        }

        // Send Single Message
        client.SendMessage(Message, Topic);
        client.Disconnect();

    }
}
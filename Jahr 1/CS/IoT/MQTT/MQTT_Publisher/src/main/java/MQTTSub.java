import com.hivemq.client.internal.mqtt.MqttRxClient;
import com.hivemq.client.mqtt.MqttGlobalPublishFilter;
import com.hivemq.client.mqtt.datatypes.MqttQos;
import com.hivemq.client.mqtt.mqtt5.Mqtt5BlockingClient;
import com.hivemq.client.mqtt.mqtt5.Mqtt5Client;
import com.hivemq.client.mqtt.mqtt5.Mqtt5RxClient;
import com.hivemq.client.mqtt.mqtt5.message.connect.connack.Mqtt5ConnAck;
import com.hivemq.client.mqtt.mqtt5.message.publish.Mqtt5Publish;
import com.hivemq.client.mqtt.mqtt5.message.subscribe.suback.Mqtt5SubAck;
import com.hivemq.client.rx.FlowableWithSingle;
import io.reactivex.Completable;
import io.reactivex.Single;

import java.util.concurrent.TimeUnit;

public class MQTTSub {

    public Mqtt5RxClient client;
    Single<Mqtt5ConnAck> connAckSingle;
    private String Server;
    private String ClientID;
    private int Port;

    public MQTTSub(String Server, int Port, String ClientID){
        this.Server = Server;
        this.ClientID = ClientID;
        this.Port = Port;
        Configure();
    }

    public void Configure(){
       client = Mqtt5Client.builder()
                .identifier(ClientID)
                .serverHost(Server)
                .serverPort(Port)
                .buildRx();
    }

    public void Connect(){
        connAckSingle = (Single<Mqtt5ConnAck>) client.connect();
    }

    public void ConnectwithCreds(String username, String password){
        client.connectWith()
                .simpleAuth()
                .username(username)
                .password(password.getBytes())
                .applySimpleAuth();
    }

    public void Disconnect(){
        client.disconnect();
    }

    public void Listening(String Topic) throws InterruptedException {
        // Same here: the following line does not subscribe yet, but returns a reactive type.
        // FlowableWithSingle is a combination of the single SubAck message and a Flowable of Publish messages.
        // A Flowable is an asynchronous stream that enables backpressure from the application over the client to the broker.
        FlowableWithSingle<Mqtt5Publish, Mqtt5SubAck> subAckAndMatchingPublishes = client.subscribeStreamWith()
                .topicFilter(Topic).qos(MqttQos.AT_LEAST_ONCE)
                .addSubscription().topicFilter(Topic).qos(MqttQos.EXACTLY_ONCE).applySubscription()
                .applySubscribe();

        // The reactive types offer many operators that will not be covered here.
        // Here we register callbacks to print messages when we received the CONNACK, SUBACK and matching PUBLISH messages.
        Completable connectScenario = connAckSingle
                .doOnSuccess(connAck -> System.out.println("Connected, " + connAck.getReasonCode()))
                .doOnError(throwable -> System.out.println("Connection failed, " + throwable.getMessage()))
                .ignoreElement();

        Completable subscribeScenario = subAckAndMatchingPublishes
                .doOnSingle(subAck -> System.out.println("Subscribed, " + subAck.getReasonCodes()))
                .doOnNext(publish -> System.out.println(
                        "Received publish" + ", topic: " + publish.getTopic() + ", QoS: " + publish.getQos() +
                                ", payload: " + new String(publish.getPayloadAsBytes())))
                .ignoreElements();

        // Reactive types can be easily and flexibly combined
        connectScenario.andThen(subscribeScenario).blockingAwait();
    }
}

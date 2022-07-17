package com.demo.activemq;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @Description: 服务器向多个客户端推送主题，即不同客户端可向服务端订阅相同的主题
 * @Author: zhouj
 * @Date: 2019/10/25 15:15
 */
public class ServerMQTT {
    // 服务器地址
    public static final String HOST = "tcp://192.168.3.85:1883";
    // 主题
    public static final String TOPIC = "mtopic";
    // 定义MQTT的ID，可以在MQTT服务配置中指定
    private static final String clientid = "server11";

    private MqttClient mqttClient;
    private MqttTopic mqttTopic;
    private String userName = "admin";
    private String passWord = "admin";

    private MqttMessage message;

    /**
     * 构造函数
     *
     * @throws MqttException
     */
    public ServerMQTT() throws MqttException {
        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
        mqttClient = new MqttClient(HOST, clientid, new MemoryPersistence());
        connect();
    }

    /**
     * 用来连接服务器
     */
    private void connect() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setUserName(userName);
        options.setPassword(passWord.toCharArray());
        // 连接超时时间
        options.setConnectionTimeout(10);
        // 会话心跳时间
        options.setKeepAliveInterval(20);
        try {
            mqttClient.setCallback(new PushCallback());
            mqttClient.connect(options);
            mqttTopic = mqttClient.getTopic(TOPIC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param topic
     * @param message
     * @throws MqttPersistenceException
     * @throws MqttException
     */
    public void publish(MqttTopic topic, MqttMessage message) throws MqttPersistenceException, MqttException {
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
        System.out.println("message is published completely! "
                + token.isComplete());
    }

    /**
     * 启动入口
     *
     * @param args
     * @throws MqttException
     */
    public static void main(String[] args) throws MqttException {
        ServerMQTT server = new ServerMQTT();
        server.message = new MqttMessage();
        server.message.setQos(2);
        server.message.setRetained(true);
        server.message.setPayload("hello,topic11".getBytes());
        server.publish(server.mqttTopic, server.message);
        System.out.println(server.message.isRetained() + "------ratained状态");
    }
}

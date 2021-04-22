package com.data2.mq.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.spring.ActiveMQConnectionFactory;

import javax.jms.*;

public class MuskteerJMS {

    public static void main(String[] args) throws JMSException {
        //producer
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = new ActiveMQQueue("testQueue");
        MessageProducer producer = session.createProducer(queue);
        Message message = session.createTextMessage("fghjkl");
        producer.send(message);

        //consume
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {

            public void onMessage(Message arg0) {
                TextMessage textMessage = (TextMessage) arg0;
                if (textMessage != null) {
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

}

package com.example.jeedemo.jmsdemo;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

public class MessageDeliveryService {

    @Resource(lookup = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/myapp/myqueue")
    private Queue inboundQueue;

    public String handleEvent(final String name) {
        try (JMSContext ctx = connectionFactory.createContext()) {
            MessageDto object = new MessageDto("https://google.com", name);
            ObjectMessage message = ctx.createObjectMessage(object);

            JMSProducer producer = ctx.createProducer();
            producer.send(inboundQueue, message);
        }
        return name;
    }
}

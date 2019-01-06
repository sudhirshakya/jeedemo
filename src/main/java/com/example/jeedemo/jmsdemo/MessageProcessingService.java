package com.example.jeedemo.jmsdemo;

import java.io.Serializable;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/myapp/myqueue") })
public class MessageProcessingService implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageProcessingService.class);

    @Override
    public void onMessage(Message message) {
        try {
            if (!(message instanceof ObjectMessage)) {
                logger.warn("Received message was not an object message. Could not proceed further.");
                return;
            }

            Serializable object = ((ObjectMessage) message).getObject();
            if (!(object instanceof MessageDto)) {
                logger.warn("Message was not an instance of MessageDto. Could not proceed further.");
                return;
            }
            MessageDto dto = (MessageDto) object;
            logger.info("Received and processing message: {}", dto);
        } catch (JMSException ex) {
            logger.warn("There was an error unpacking message {}.", ex.getMessage());
        }
    }

}

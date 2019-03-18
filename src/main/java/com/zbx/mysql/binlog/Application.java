package com.zbx.mysql.binlog;


import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;

import java.io.IOException;

public class Application {

    public static void main(String[] args) {
        try{
            BinaryLogClient client = new BinaryLogClient("", 3306, "username", "password");
            EventDeserializer eventDeserializer = new EventDeserializer();
            eventDeserializer.setCompatibilityMode(
                    EventDeserializer.CompatibilityMode.DATE_AND_TIME_AS_LONG,
                    EventDeserializer.CompatibilityMode.CHAR_AND_BINARY_AS_BYTE_ARRAY
            );
            client.setEventDeserializer(eventDeserializer);
            client.registerEventListener(new BinaryLogClient.EventListener() {

                @Override
                public void onEvent(Event event) {
                }
            });
            client.connect();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
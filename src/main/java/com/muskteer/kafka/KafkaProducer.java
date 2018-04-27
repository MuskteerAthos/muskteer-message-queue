package com.muskteer.kafka;

import java.util.Map;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaProducer {
	static Producer<String, String> producer = null;
	static{
		Properties props = new Properties();
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("metadata.broker.list", "10.143.130.62:9096");
		props.put("request.required.acks", 1);
		props.put("partitioner.class", "com.muskteer.kafka.Partion");
		props.put("producer.type", "async");//异步
		props.put("compression.codec", "gzip");
		@SuppressWarnings("unused")
		Producer<String, String> producer = 
				new Producer<String, String>(new ProducerConfig(props));
	}
	
	public static void info(String topic, String key, Map<?, ?> val){
		String value = null;
//		value = map//map转json串
		producer.send(new KeyedMessage<String, String>(topic, key, value));
	}

}

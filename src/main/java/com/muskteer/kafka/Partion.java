package com.muskteer.kafka;

import kafka.producer.Partitioner;

public class Partion implements Partitioner{

	@Override
	public int partition(Object obj, int numPartitions) {
		int partition = 0;     
        if (obj instanceof String) {  
            int key=Integer.parseInt((String) obj) ; 
                partition = key%numPartitions; //
        }else{  
            partition = obj.toString().length() % numPartitions;  
        }  
        return partition;  
	}

}

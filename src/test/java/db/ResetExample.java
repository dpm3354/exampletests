package db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;


import redis.clients.jedis.Jedis;

public class ResetExample {

	public static void main(String[] args) {
		// Connecting to Redis server on localhost
		Jedis jedis = new Jedis("localhost");
		System.out.println("Connection to server sucessfully");
		// set the data in redis string
		jedis.set("tutorial-name1", "Redis tutorial");
		jedis.set("tutorial-name2", "Redis tutorial");
		// Get the stored data and print it
//		System.out.println("Stored string in redis:: " + jedis.get("tutorial-name"));
		System.out.println("Stored string in redis:: " + jedis.mget("tutorial-name1", "tutorial-name2"));
		
		jedis.del("tutorial-name1", "tutorial-name2");
		System.out.println("Stored string in redis:: " + jedis.mget("tutorial-name1", "tutorial-name2"));
		
	}
	
}

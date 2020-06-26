package com;

import org.junit.Test;

public class SocketTest {
	@Test
	public void testSocket(){
		SocketServer server = new SocketServer();
		SocketClient client = new SocketClient();
		Thread t1 = new Thread(new Runnable() {
			public void run() {				
				server.start();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {				
				client.connect();
			}
		});
		
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assert server.getMsg().equals("Hello Server");
	}
}

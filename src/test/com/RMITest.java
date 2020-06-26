package com;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

import rmi.ClientOperation;
import rmi.ServerOperation;

public class RMITest {
	@Test
	public void RMIOpTest(){
		try {
			ServerOperation server = new ServerOperation();
			ClientOperation client = new ClientOperation();
			
			server.start();
			client.connect();
			
			assert client.getMsg().equals("Server says hello to mike");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}

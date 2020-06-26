package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientOperation {
	private static RMIInterface look_up;
	
	private String msg;

	public void connect()
		throws MalformedURLException, RemoteException, NotBoundException {

		look_up = (RMIInterface) Naming.lookup(Configuration.address);
		String txt = "mike";

		String response = look_up.helloTo(txt);

		this.setMsg(response);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

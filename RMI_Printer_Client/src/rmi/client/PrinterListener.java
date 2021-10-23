package rmi.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmi.IPrinter;

public class PrinterListener implements ActionListener{
	private String userName;
	private String printer;
	private String fileName;
	public PrinterListener(String userName,String printer,String fileName) {
		this.userName=userName;
		this.printer=printer;
		this.fileName=fileName;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			IPrinter printerServer = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/server");
			printerServer.print(userName, printer, fileName);
		} catch (Exception ex) {
			System.out.println("����Զ�̶���ʧ�ܣ�ԭ���ǣ�"+ex.getMessage());
		}
	}

}

package rmi.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import rmi.IPrinter;

//�Ե��ýӿڵķ�����ʵ��
public class PrinterImpl extends UnicastRemoteObject implements IPrinter{
	public PrinterImpl() throws RemoteException {
	    super();
	  }
	
	//��ӡ��������"printer"��ӡ���ϴ�ӡ"filename"�ļ�
	@Override
	public void print(String fileName, String printer) throws RemoteException{
		String fileContent;
		String filePath="file/"+fileName+".txt";
		FileInputStream fin;
		try {
			fin = new FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            System.out.println(printer+" now start to print."+fileName);
            while ((fileContent=buffReader.readLine()) != null){
            	System.out.println(fileContent);
            	}
            System.out.println(printer+" finished.");
            }catch(Exception e) {
            	System.out.println(e);
		}
		
	}
		
	//��ʾĿǰ"printer"�Ĵ�ӡ���У���Ҫ��ʾ"job number"��"filename"
	@Override
	public void queue(String printer) throws RemoteException{
		
	}
		
	//��"job"���������"printer"�Ĵ�ӡ���ж���
	@Override
	public void topQueue(String printer, int job) throws RemoteException{
		
	}
		
	//������ӡ������
	@Override
	public void start() throws RemoteException{
		
	}
		
	//�رմ�ӡ������
	@Override
	public void stop() throws RemoteException{
		
	}
		
	//������ӡ��������մ�ӡ������
	@Override
	public void restrat() throws RemoteException{
		
	}
		
	//��ʾ��ӡ����״̬
	@Override
	public void status(String printer) throws RemoteException{
		
	}
		
	//��ȡ�û�����
	@Override
	public void readConfig(String parameter) throws RemoteException{
		
	}
		
	//�����û�����
	@Override
	public void setConfig(String parameter, String value) throws RemoteException{
		
	}
	
	//�÷���Ϊʾ��������������ע�͵�
	@Override
	public void example(String example) throws RemoteException {
		 System.out.println(example+"������ʾ������,�÷�������Impl��ʵ�ֵġ�");
		 return;
	}
	
	//У���û���������
	@Override
	public boolean isCustomer(String userName, String userPassword) throws RemoteException {
		boolean isFound = false;
	    String record_userName;
	    String record_userPassword;
	    String filePath = "login.txt";
        FileInputStream fin;
        //һ��һ�ж�ȡ�û��������룬���û�������ƥ��ʱ����true�����򷵻�false
		try {
			fin = new FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
	        while ((record_userName=buffReader.readLine()) != null){
	        	if (userName.equals(record_userName)) {
	            	record_userPassword=buffReader.readLine();
	            	if(record_userPassword.equals(record_userPassword)) {
	            		isFound=true;
	            		}
	            	}
	        	}
	        buffReader.close();
	        buffReader = null;
	        }catch(Exception e){
	        	System.out.println(e);
	        	}
		if(isFound==true) {
			 System.out.println(userName+"���У��ͨ��.");
		}
		else {
			 System.out.println("������ƥ����˺�����.");
		}
		return isFound;
	}
}

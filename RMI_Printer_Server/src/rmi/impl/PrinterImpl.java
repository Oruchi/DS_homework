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
	public boolean print(String userName, String fileName, String printer) throws RemoteException{
		String fileContent;
		String state;
		boolean printerStates = false;
		FileInputStream fin_1;
		FileInputStream fin_2;
		String printerPath="printer/"+printer+".txt";
		String filePath="file/"+fileName+".txt";
		try {
			fin_1 = new FileInputStream(printerPath);
			InputStreamReader reader = new InputStreamReader(fin_1);
            BufferedReader buffReader = new BufferedReader(reader);
            while((state=buffReader.readLine()) != null) {
            	if(state.equals("start")) {
            		printerStates=true;
            	}
            }
		}catch(Exception e) {
			System.out.println(e);
		}
		if(printerStates==true) {
			try {
				fin_2 = new FileInputStream(filePath);
	            InputStreamReader reader = new InputStreamReader(fin_2);
	            BufferedReader buffReader = new BufferedReader(reader);
	            System.out.println(printer+" now start to print."+fileName);
	            while ((fileContent=buffReader.readLine()) != null){
	            	System.out.println(fileContent);
	            	}
	            System.out.println(printer+" finished.");
	            }catch(Exception e) {
	            	System.out.println(e);
	            	return true;
			}
		}
		else System.out.println(printer+" is not working now!");
		return false;
	}
		
	//��ʾĿǰ"printer"�Ĵ�ӡ���У���Ҫ��ʾ"job number"��"filename"
	@Override
	public String queue(String userName, String printer) throws RemoteException{
		String queue;
		FileInputStream fin;
		String printerPath="printer/"+printer+".txt";
		try {
			fin = new FileInputStream(printerPath);
			InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            while((queue=buffReader.readLine()) != null) {
            	if(queue.equals("queue")) {
            		queue=buffReader.readLine();
            		if(queue!=null) return queue;
            		else return "";
            	}
            }
		}catch(Exception e) {
			System.out.println(e);
		}
		return "";
	}
		
	//��"job"���������"printer"�Ĵ�ӡ���ж���
	@Override
	public boolean topQueue(String userName, String printer, int job) throws RemoteException{
		String queue;
		FileInputStream fin;
		String printerPath="printer/"+printer+".txt";
		try {
			fin = new FileInputStream(printerPath);
			InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            while((queue=buffReader.readLine()) != null) {
            	if(queue.equals("queue")) {
            		queue=buffReader.readLine();
            		
            	}
            }
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
		
	//������ӡ������
	@Override
	public void start(String userName) throws RemoteException{
		
	}
		
	//�رմ�ӡ������
	@Override
	public void stop(String userName) throws RemoteException{
		
	}
		
	//������ӡ��������մ�ӡ������
	@Override
	public void restart(String userName) throws RemoteException{
		
	}
		
	//��ʾ��ӡ����״̬
	@Override
	public void status(String userName, String printer) throws RemoteException{
		
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
	        	if(record_userName.equals("user"))
	        		record_userName=buffReader.readLine();
	        	if (userName.equals(record_userName)) {
	            	record_userPassword=buffReader.readLine();
	            	if(userName.equals(record_userName)&&userPassword.equals(record_userPassword)) {
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
			 System.out.println(userName+"login success.");
		}
		else {
			 System.out.println(userName+"login failed.");
		}
		return isFound;
	}


}

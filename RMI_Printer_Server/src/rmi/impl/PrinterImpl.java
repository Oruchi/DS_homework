package rmi.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import rmi.IPrinter;
import sha2.PasswordAuthentication;

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
		System.out.println(userName+" is trying to print "+fileName+" on the "+printer);
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
		System.out.println(userName+" is trying to check "+printer+"'s queue");
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
	public boolean topQueue(String userName, String printer, String job) throws RemoteException{
		String temp = "";
        String printerPath="printer/"+printer+".txt";
        try {
            File file = new File(printerPath);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();
            // �������ǰ�������
            for (int j = 1; (temp = br.readLine()) != null
                    && !temp.equals("queue"); j++) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }
            // �����ݲ���
            buf = buf.append("queue");
            buf = buf.append(System.getProperty("line.separator"));
            temp=br.readLine();
            String[]s=temp.split(",");
            String s1=job;
            for(int i=0;i<s.length;i++) {
            	if(!s[i].equals(job)) {
            		s1=s1+","+s[i];
            	}
            }
            buf.append(s1);
            // ������к��������
            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
	}
		
	//������ӡ������
	@Override
	public void start(String userName,String printer) throws RemoteException{
        String temp = "";
        String printerPath="printer/"+printer+".txt";
        try {
            File file = new File(printerPath);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();
            // �������ǰ�������
            for (int j = 1; (temp = br.readLine()) != null
                    && !temp.equals("stop"); j++) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }
            // �����ݲ���
            buf = buf.append("start");
            // ������к��������
            while ((temp = br.readLine()) != null) {
                buf = buf.append(System.getProperty("line.separator"));
                buf = buf.append(temp);
            }
            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
		
	//�رմ�ӡ������
	@Override
	public void stop(String userName,String printer) throws RemoteException{
		String temp = "";
        String printerPath="printer/"+printer+".txt";
        try {
            File file = new File(printerPath);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();
            // �������ǰ�������
            for (int j = 1; (temp = br.readLine()) != null
                    && !temp.equals("start"); j++) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }
            // �����ݲ���
            buf = buf.append("stop");
            // ������к��������
            while ((temp = br.readLine()) != null) {
                buf = buf.append(System.getProperty("line.separator"));
                buf = buf.append(temp);
            }
            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
		
	//������ӡ��������մ�ӡ������
	@Override
	public void restart(String userName,String printer) throws RemoteException{
		String temp = "";
        String printerPath="printer/"+printer+".txt";
        try {
            File file = new File(printerPath);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();
            // �������ǰ�������
            for (int j = 1; (temp = br.readLine()) != null
                    && (!temp.equals("start")&&!temp.equals("stop")); j++) {
                buf = buf.append(temp);
                buf = buf.append(System.getProperty("line.separator"));
            }
            // �����ݲ���
            buf = buf.append("stop");
            while ((temp = br.readLine()) != null&&temp.equals("queue")) {
                buf = buf.append(System.getProperty("line.separator"));
                buf = buf.append(temp);
            }
            br.close();
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.write(buf.toString().toCharArray());
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
		
	//��ʾ��ӡ����״̬
	@Override
	public String states(String userName, String printer) throws RemoteException{
		String state;
		FileInputStream fin;
		String printerPath="printer/"+printer+".txt";
		System.out.println(userName+" is trying to check "+printer+"'s state ");
		try {
			fin = new FileInputStream(printerPath);
			InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            while((state=buffReader.readLine()) != null) {
            	if(state.equals("state")) {
            		state=buffReader.readLine();
            		if(state!=null) return state;
            		else return "";
            	}
            }
		}catch(Exception e) {
			System.out.println(e);
		}
		return "";
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
		String filePath = "login.txt";
		PasswordAuthentication pwdAuth = new PasswordAuthentication();
		return pwdAuth.passwordAuthentication(userName, userPassword, filePath);
	}

}

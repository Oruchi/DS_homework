package rmi.impl;

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
	public void print(String filename, String printer) throws RemoteException{
		
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
}

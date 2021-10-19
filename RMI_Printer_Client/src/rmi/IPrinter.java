package rmi;
import java.rmi.Remote;

//����Զ�̽ӿ�,Server����Ҫ�ķ�����Ӹýӿڵ��ò���
public interface IPrinter extends Remote{
	
	//��ӡ��������"printer"��ӡ���ϴ�ӡ"filename"�ļ�
	public void print(String filename, String printer) throws java.rmi.RemoteException;
	
	//��ʾĿǰ"printer"�Ĵ�ӡ���У���Ҫ��ʾ"job number"��"filename"
	public void queue(String printer) throws java.rmi.RemoteException;
	
	//��"job"���������"printer"�Ĵ�ӡ���ж���
	public void topQueue(String printer, int job) throws java.rmi.RemoteException;
	
	//������ӡ������
	public void start() throws java.rmi.RemoteException;
	
	//�رմ�ӡ������
	public void stop() throws java.rmi.RemoteException;
	
	//������ӡ��������մ�ӡ������
	public void restrat() throws java.rmi.RemoteException;
	
	//��ʾ��ӡ����״̬
	public void status(String printer) throws java.rmi.RemoteException;
	
	//��ȡ�û�������id���û���
	public void readConfig(String parameter) throws java.rmi.RemoteException;
	
	//�����û��������û��������룺
	public void setConfig(String parameter, String value) throws java.rmi.RemoteException;
	
	//�÷���Ϊʾ��������������ע�͵�
	public void example(String example) throws  java.rmi.RemoteException;
	
	//У���û���������
	public void isCustomer(String userName,String userPassword) throws  java.rmi.RemoteException;
	
}

package rmi.client;
import java.rmi.*;
import rmi.IPrinter;

//�ͻ��ˣ��������ΪѧУͼ��ݴ�ӡ���նˣ���Ҫ�����û����봫��İ�ȫ����
public class PrinterClient {
	public static void main(String[] args) {
		//�����û�������
		//������У���û���������ȷ������ӡ����
		//�û�ѡ���Լ�����Ҫ�ķ���
		//��ӡ�ļ�
		//��ʾ�ļ�����
		//ָ���ļ��ö�
		//��ʾ��ӡ��״̬
		//��ȡ�û�������id���û���
		//�����û��������û���������
		//�˳�
		//����
		
		//�÷���Ϊʾ����������������ɾ����ע��
		try {
			IPrinter example = (IPrinter) Naming.lookup("rmi://127.0.0.1:8888/example");
			example.example("Pinter1");
			example.isCustomer("123", "1234");
			example.print("file_1", "printer1");
			System.out.println("���óɹ���");
		}catch(Exception e) {
			System.out.println("����Զ�̶���ʧ�ܣ�ԭ���ǣ�"+e.getMessage());
		}
	}
}

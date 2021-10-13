package rim.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import rmi.IText;


public class TextClient {

  public static void main(String[] args) {

    try {
      
      /*
      ����ָ�����ֵ�Զ�� �����һ������
       */
      IText hello = (IText) Naming.lookup("rmi://127.0.0.1:8888/hello");
      System.out.println("����Զ�̶��󣬿�ʼ���ԣ�"+hello.sayText("��÷÷"));
    } catch (Exception e) {
      System.out.println("����Զ�̶���ʧ�ܣ�ԭ���ǣ�"+e.getMessage());
    }
  }
}

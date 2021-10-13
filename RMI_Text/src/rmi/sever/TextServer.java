package rmi.sever;

import java.rmi.registry.LocateRegistry;
import rmi.IText;
import rmi.impl.TextImpl;

public class TextServer {
  public static void main(String[] args) {
    try {
      IText hello = new TextImpl();
      /*
      ������ip�ϴ������ṩһ����ע���ʵ������������ָ�����˿ڡ�������
       */
      LocateRegistry.createRegistry(8888);

      /*
      ��һ��Զ�̶������°�һ����������������
      @param name:����Ϊһ��URI��ʽ
      ��������Ḳ��֮ǰ�Ѿ��󶨵�����
       */
      java.rmi.Naming.rebind("rmi://127.0.0.1:8888/hello", hello);
      System.out.print("Ready");
    } catch (Exception e) {
      System.out.println("�ṩԶ�̶���ʧ�ܣ�ԭ���ǣ�"+e.getMessage());
    }
  }
}

package rmi;
import java.rmi.Remote;

//����Զ�̽ӿ�
public interface IText extends Remote{

	 public String sayText(String name) throws java.rmi.RemoteException;
	 
}

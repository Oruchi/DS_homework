package rmi.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.IText;

public class TextImpl extends UnicastRemoteObject implements IText {

  public TextImpl() throws RemoteException {
    super();
  }

  @Override
  public String sayText(String name) throws RemoteException {
    System.out.println("����text����");
    return name+"˵��text";

  }
}
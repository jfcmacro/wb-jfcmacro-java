package rexec.inter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RExec extends Remote  {

    public Integer compile(String path, String sourceName) throws RemoteException;
}
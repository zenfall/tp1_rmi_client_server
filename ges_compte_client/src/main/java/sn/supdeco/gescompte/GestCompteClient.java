package sn.supdeco.gescompte;

import sn.supdeco.gescompte.models.Utilisateur;
import sn.supdeco.gescompte.services.IOperation;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Hello world!
 *
 */
public class GestCompteClient
{
    public static void main( String[] args )
    {


        try{
            IOperation operation = (IOperation) Naming.lookup("rmi://localhost:2000/operation");
            Utilisateur utilisateur = operation.creerUtilisateur(new Utilisateur("1", "FALL", "Hassan"));
            System.out.println(String.format("prenom : %s", utilisateur.getPrenom()));

        }catch (RemoteException  | NotBoundException | MalformedURLException e){
            System.out.println(String.format("error : %s",e.getMessage()));

        }
    }
}

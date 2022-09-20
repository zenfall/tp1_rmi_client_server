package sn.supdeco.gescompte;

import sn.supdeco.gescompte.exceptions.CompteDebitException;
import sn.supdeco.gescompte.models.Compte;
import sn.supdeco.gescompte.models.Utilisateur;
import sn.supdeco.gescompte.services.IOperation;
import sn.supdeco.gescompte.services.OperationsService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

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
            OperationsService operationsService = null;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Saisir l'identifiant de l'utilisateur ");
            String id = scanner.next();
            System.out.println("Identifiant : "+id);
            System.out.println("Saisir le nom de l'utilisateur ");
            String nom = scanner.next();
            System.out.println("Saisir le prenom de l'utilisateur ");
            String prenom = scanner.next();
            Utilisateur utilisateur = operation.creerUtilisateur(new Utilisateur(id, nom, prenom));
            Compte compte = operation.creerCompte(utilisateur);








            System.out.println(String.format("prenom : %s", utilisateur.getPrenom()));

            System.out.println(compte);
            System.out.println(String.format("solde compte 2 %s: ", compte.getCompteId()));

            System.out.println("Montant à créditer");
            double f = scanner.nextDouble();
            compte = operation.crediterCompte(compte,f);
            double solde = operation.consulterCompte(compte);
            System.out.println(String.format("solde compte 1  %s: ", solde ));
            System.out.println("entre"+compte);
            System.out.println(""+operation);
            operationsService.debiterCompte(operation,compte);
            System.out.println("sorti");

            System.out.println("Consulter compte");

            solde = operation.consulterCompte(compte);
            System.out.println(String.format("solde compte 1  %s: ", solde ));

        }catch (RemoteException | NotBoundException | MalformedURLException | CompteDebitException e){
            System.out.println(String.format("error : %s",e.getMessage()));

        }
    }
}

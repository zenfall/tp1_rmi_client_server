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
    public static void main( String[] args ) throws RemoteException {

        try{
            IOperation operation = (IOperation) Naming.lookup("rmi://localhost:2000/operation");
            OperationsService operationsService = new OperationsService();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Vous devez remplir les information demandées pour créer un utilisateur");
            System.out.println("Saisir l'identifiant de l'utilisateur");
            String id = scanner.next();
            System.out.println("Identifiant : "+id);
            System.out.println("Saisir le nom de l'utilisateur ");
            String nom = scanner.next();
            System.out.println("Saisir le prenom de l'utilisateur");
            String prenom = scanner.next();
            Utilisateur utilisateur = operation.creerUtilisateur(new Utilisateur(id, nom, prenom));
            Compte compte = operation.creerCompte(utilisateur);

            System.out.println("Faites votre choix: ");

            System.out.println("1. Créditer le compte");
            System.out.println("2. Débiter le compte");
            System.out.println("3. Consulter le compte");
            System.out.println("4. Quitter");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    operationsService.crediterCompte(operation,compte);
                    break;
                case 2:
                    operationsService.debiterCompte(operation,compte);
                    break;
                case 3:
                    operationsService.consulterSolde(compte,operation);
                    break;
                case 4:

                    break;

            }
            if(choice !=4){
                operationsService.creerUtilisateur(operation);
            }

        }catch (RemoteException | NotBoundException | MalformedURLException | CompteDebitException e ){
            System.out.println(String.format("error : %s",e.getMessage()));

        }
    }
}

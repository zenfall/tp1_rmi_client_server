package sn.supdeco.gescompte.services;

import sn.supdeco.gescompte.exceptions.CompteDebitException;
import sn.supdeco.gescompte.models.Compte;
import sn.supdeco.gescompte.models.Utilisateur;

import java.rmi.RemoteException;
import java.rmi.server.Operation;
import java.util.Scanner;

public class OperationsService {
    Scanner scanner = new Scanner(System.in);

    public void debiterCompte(IOperation operation, Compte compte) throws RemoteException, CompteDebitException {

        System.out.println("Merci de saisir le montant debit");
        double f = scanner.nextDouble();
        Compte compte2 = operation.debiterCompte(compte,f);
        double solde = operation.consulterCompte(compte2);
        System.out.println(String.format("solde  de votre compte est  %s: ", solde ));
    }

    public void crediterCompte(IOperation operation, Compte compte) throws RemoteException, CompteDebitException {
        System.out.println("Merci de saisir le montant crédit");
        double f = scanner.nextDouble();
        compte = operation.crediterCompte(compte,f);
        double solde = operation.consulterCompte(compte);
        System.out.println(String.format("solde  de votre compte est  %s: ", solde ));
    }

    public void consulterSolde(Compte compte,IOperation operation) throws RemoteException {


        double solde = operation.consulterCompte(compte);
        System.out.println(String.format("solde  de votre compte est  %s: ", solde ));
    }

    public Compte creerUtilisateur(IOperation operation) throws RemoteException {
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
        return compte;
    }




}

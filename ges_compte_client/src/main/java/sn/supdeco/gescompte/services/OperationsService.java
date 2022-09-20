package sn.supdeco.gescompte.services;

import sn.supdeco.gescompte.exceptions.CompteDebitException;
import sn.supdeco.gescompte.models.Compte;

import java.rmi.RemoteException;
import java.rmi.server.Operation;
import java.util.Scanner;

public class OperationsService {
    Scanner scanner = new Scanner(System.in);

    public void debiterCompte(IOperation operation, Compte compte) throws RemoteException, CompteDebitException {

        System.out.println("Montant à debiter");
        double f = scanner.nextDouble();
        Compte compte2 = operation.debiterCompte(compte,f);
        double solde = operation.consulterCompte(compte2);
        System.out.println(String.format("le solde de votre compte est  %s: ", solde ));
    }
}

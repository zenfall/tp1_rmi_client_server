package sn.supdeco.gescompte.services;

import sn.supdeco.gescompte.exceptions.CompteDebitException;
import sn.supdeco.gescompte.models.Compte;
import sn.supdeco.gescompte.models.Utilisateur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOperation extends Remote {

    Utilisateur creerUtilisateur(Utilisateur utilisateur) throws RemoteException;
    Compte creerCompte(Utilisateur utilisateur) throws RemoteException;
    Compte debiterCompte(Compte compte, double montant) throws RemoteException, CompteDebitException;
    Compte crediterCompte(Compte compte, double montant) throws RemoteException;
    double consulterCompte(Compte compte) throws RemoteException;


}

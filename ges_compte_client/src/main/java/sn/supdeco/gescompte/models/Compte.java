package sn.supdeco.gescompte.models;

import sn.supdeco.gescompte.exceptions.CompteDebitException;

import java.io.Serializable;

public class Compte implements Serializable {
    private String compteId;
    private double solde;
    private Utilisateur utilisateur;

    public Compte(String compteId, double solde, Utilisateur utilisateur) {
        this.compteId = compteId;
        this.solde = solde;
        this.utilisateur = utilisateur;
    }

    public String getCompteId() {
        return compteId;
    }

    public void setCompteId(String compteId) {
        this.compteId = compteId;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void debiterCompte(double montant) throws CompteDebitException {
        double soldeRestant = solde - montant;
        if(soldeRestant < - 1000){
            throw new CompteDebitException(String.format("votre compte ne peut etre debiter de %s", montant));

        }
        setSolde(soldeRestant);
    }

    public void crediterCompte(double montant ) {
        setSolde(solde + montant);
    }


}

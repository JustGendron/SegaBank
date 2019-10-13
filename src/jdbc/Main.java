package jdbc;

import jdbc.DAO.*;
import jdbc.bo.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static IDAO<Integer, Integer, Compte> daoC = new CompteDAO();
    private static IDAO<Integer, Integer, Agence> daoA = new AgenceDAO();
    private static IDAO<Integer, Integer, Simple> daoS = new SimpleDAO();
    private static IDAO<Integer, Integer, Epargne> daoE = new EpargneDAO();
    private static IDAO<Integer, Integer, Payant> daoP = new PayantDAO();

    private static Scanner sc = new Scanner( System.in );

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {


        //System.out.println(daoC.findByCode(1));
        daoC.remove(daoC.findByCode(1));


        bankMainMenu(); // lancement menu

        /*IDAO<Agence> dao = new AgenceDAO();
        Agence agence = new Agence(2, "rue");
        System.out.println( agence );

        try {
           dao.create( agence );
            System.out.println( agence );
        } catch ( IOException | ClassNotFoundException | SQLException e ) {
            System.err.println( e.getMessage() );
        }*/

    }

    public static void bankMainMenu() throws SQLException, IOException, ClassNotFoundException {

        int response;
        boolean first = true;

        do {
            if(!first) {
                System.out.println("Mauvais choix !");
            }
            System.out.println("======================================" );
            System.out.println("=========== MENU SEGABANK ============" );
            System.out.println("======================================" );
            System.out.println("1 - Lister toutes les agences");
            System.out.println("2 - Lister tout les comptes");
            System.out.println("3 - Lister tout les comptes par agences");
            System.out.println("4 - Ajouter une nouvelle agence");
            System.out.println("5 - Ajouter un nouveau compte ");
            System.out.println("6 - Faire une operation sur un compte ");
            System.out.println("7 - Calculer son taux d'interet ");
            System.out.println("8 - Supression d'un compte");
            System.out.println("9 - Quitter");
            System.out.print("Entrez votre choix : " );

            try {
                response = sc.nextInt();
            } catch (InputMismatchException e) {
                response = -1;
            } finally {
                sc.nextLine();
            }
            first = false;
        } while (response < 1 || response > 9);

        switch(response) {
            case 1:
                System.out.println("==Liste des agences==");
                listerAgences();
                break;
            case 2 :
                System.out.println("==Liste des comptes==");
                listerComptes();
                break;
            case 3:
                System.out.println("==Liste compte par agence==");
                listerComptesParAgences();
                break;
            case 4:
                System.out.println("==Creation d'une nouvelle agence==");
                ajouterAgence();
                break;

            case 5:
                System.out.println("==Creation d'un nouveau compte==");
                ajouterCompte();
                break;

            case 6:
                System.out.println("==Operation sur un compte==");
                operationCompte();
                break;

            case 7:
                System.out.println("==Calcul taux interet==");
                calculTauxInteret();
                break;

            case 8:
                System.out.println("==Supression d'un compte==");
                suppressionCompte();
                break;
                
        }

    }

    private static void suppressionCompte() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("======================================");
        System.out.println("======== SUPRESSION DE COMPTE ========");
        System.out.println("======================================");
        System.out.println("Code du compte : ");
        String codeCompte = sc.nextLine();
        daoC.remove(daoC.findByCode(Integer.parseInt(codeCompte)));
        System.out.println("Compte " + codeCompte + " supprimé avec succes");
    }

    private static void calculTauxInteret() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("======================================");
        System.out.println("======== CALCUL TAUX INTERET =========");
        System.out.println("======================================");
        System.out.println("Code du compte : ");
        String codeCompte = sc.nextLine();
        Epargne epargne = daoE.findByCode(Integer.parseInt(codeCompte));
        epargne.calculInteret(epargne.getTauxInteret());
        System.out.println("Vous avez gagné " + epargne.getTauxInteret() + " ce qui vous fait un solde de " + epargne.calculInteret(epargne.getTauxInteret()));
    }

    private static void operationCompte() throws SQLException, IOException, ClassNotFoundException {

        int response = 0;
        boolean first = true;


        first = false;
        do {
            if (!first) {
                System.out.println("Mauvais choix !");
            }
            System.out.println("======================================");
            System.out.println("======== OPERATION SUR COMPTE ========");
            System.out.println("======================================");
            System.out.println("1- Versement");
            System.out.println("2- Retrait");
            System.out.println("3- Quitter");
            System.out.println("Votre choix : ");

            try {
                response = sc.nextInt();
            } catch (InputMismatchException e) {
                response = -1;
            } finally {
                sc.nextLine();
            }

        } while (response < 1 || response > 9);

        switch(response) {
            case 1:
                System.out.println("== Versement ==");
                operationVersementCompte();
                break;

            case 2:
                System.out.println("== Retrait ==");
                operationRetraitCompte();
                break;
        }

    }

    private static void operationRetraitCompte() throws SQLException, IOException, ClassNotFoundException {

        int response = 0;
        boolean first = true;
        do {
            if (!first) {
                System.out.println("Mauvais choix !");
            }
            System.out.println("======================================");
            System.out.println("======== RETRAIT SUR COMPTE ========");
            System.out.println("======================================");
            System.out.println("1- Compte Simple");
            System.out.println("2- Compte Payant");
            System.out.println("3- Compte Epargne");
            System.out.println("4- Quitter");
            System.out.println("Votre choix : ");

            try {
                response = sc.nextInt();
            } catch (InputMismatchException e) {
                response = -1;
            } finally {
                sc.nextLine();
            }

        } while (response < 1 || response > 9);

        switch(response) {
            case 1:
                System.out.println("== Compte Simple ==");
                System.out.println("Code du compte : ");
                String codeS = sc.nextLine();
                Simple simple = daoS.findByCode(Integer.parseInt(codeS));
                System.out.println("Montant retrait : ");
                String retraitS = sc.nextLine();
                simple.retrait(Float.parseFloat(retraitS));
                System.out.println("Retrait de "+retraitS+" effectué !");
                daoS.update(simple);
                break;

            case 2:
                System.out.println("== Compte Payant ==");
                System.out.println("Code du compte : ");
                String codeP = sc.nextLine();
                Payant payant = daoP.findByCode(Integer.parseInt(codeP));
                System.out.println("Montant retrait : ");
                String retraitP = sc.nextLine();
                payant.retrait(Float.parseFloat(retraitP));
                System.out.println("Retrait de "+retraitP+" effectué !");
                daoP.update(payant);
                break;

            case 3:
                System.out.println("== Compte Epargne ==");
                System.out.println("Code du compte : ");
                String codeE = sc.nextLine();
                Epargne epargne = daoE.findByCode(Integer.parseInt(codeE));
                System.out.println("Montant retrait : ");
                String retraitE = sc.nextLine();
                epargne.retrait(Float.parseFloat(retraitE));
                System.out.println("Retrait de "+retraitE+" effectué !");
                daoE.update(epargne);
                break;
        }

    }

    private static void operationVersementCompte() throws SQLException, IOException, ClassNotFoundException {

        int response = 0;
        boolean first = true;
        do {
            if (!first) {
                System.out.println("Mauvais choix !");
            }
            System.out.println("======================================");
            System.out.println("======== VERSEMENT SUR COMPTE ========");
            System.out.println("======================================");
            System.out.println("1- Compte Simple");
            System.out.println("2- Compte Payant");
            System.out.println("3- Compte Epargne");
            System.out.println("4- Quitter");
            System.out.println("Votre choix : ");

            try {
                response = sc.nextInt();
            } catch (InputMismatchException e) {
                response = -1;
            } finally {
                sc.nextLine();
            }

        } while (response < 1 || response > 9);

        switch(response) {
            case 1:
                System.out.println("== Compte Simple ==");
                System.out.println("Code du compte : ");
                String codeS = sc.nextLine();
                Simple simple = daoS.findByCode(Integer.parseInt(codeS));
                System.out.println("Montant versement : ");
                String versementS = sc.nextLine();
                simple.versement(Float.parseFloat(versementS));
                System.out.println("Versement de "+versementS+" effectué !");
                daoS.update(simple);
                break;

            case 2:
                System.out.println("== Compte Payant ==");
                System.out.println("Code du compte : ");
                String codeP = sc.nextLine();
                Payant payant = daoP.findByCode(Integer.parseInt(codeP));
                System.out.println("Montant versement : ");
                String versementP = sc.nextLine();
                payant.versement(Float.parseFloat(versementP));
                System.out.println("Versement de "+versementP+" effectué !");
                daoP.update(payant);
                break;

            case 3:
                System.out.println("== Compte Epargne ==");
                System.out.println("Code du compte : ");
                String codeE = sc.nextLine();
                Epargne epargne = daoE.findByCode(Integer.parseInt(codeE));
                System.out.println("Montant versement :");
                String versementE = sc.nextLine();
                epargne.versement(Float.parseFloat(versementE));
                System.out.println("Versement de "+versementE+" effectué !");
                daoE.update(epargne);
                break;
        }
    }

    private static void listerComptesParAgences() throws SQLException, IOException, ClassNotFoundException {

        System.out.print("Entrez l'id de l'agence : ");
        String id = sc.nextLine();
        int idagence= Integer.parseInt(id);

        for (int i = 0; i < (daoS.findByIdList(idagence)).size(); i++){
            System.out.println(" == Compte " + daoS.findByIdList(idagence).get(i).getCode() + " (Simple) ==" );
            System.out.print("- Solde : ");
            System.out.println(daoS.findByIdList(idagence).get(i).getSolde());
            System.out.print("- Decouvert : ");
            System.out.println(daoS.findByIdList(idagence).get(i).getDecouvert());
            System.out.print("- Agence : ");
            System.out.println(daoS.findByIdList(idagence).get(i).getIdagence());
        }/*
        for (int i = 0; i < (daoP.findByIdList(idagence)).size(); i++){
            System.out.println(" == Compte " + daoP.findByIdList(idagence).get(i).getCode() + " (Payant) ==" );
            System.out.print("- Solde : ");
            System.out.println(daoP.findByIdList(idagence).get(i).getSolde());
            System.out.print("- Agence : ");
            System.out.println(daoP.findByIdList(idagence).get(i).getIdagence());
        }
        for (int i = 0; i < (daoE.findByIdList(idagence)).size(); i++){
            System.out.println(" == Compte " + daoE.findByIdList(idagence).get(i).getCode() + " (Epargne) ==" );
            System.out.print("- Solde : ");
            System.out.println(daoE.findByIdList(idagence).get(i).getSolde());
            System.out.print("- Agence : ");
            System.out.println(daoE.findByIdList(idagence).get(i).getIdagence());
        }*/



        bankMainMenu();

    }


    private static void ajouterCompte() throws SQLException, IOException, ClassNotFoundException {

        int response;
        boolean first = true;


        do {
            if(!first) {
                System.out.println("Mauvais choix !");
            }

            System.out.println( "======================================" );
            System.out.println( "======== CREATION D'UN COMPTE ========" );
            System.out.println( "======================================" );
            System.out.println( "Choix du type de compte :" );
            System.out.println( "1 - Compte Simple" );
            System.out.println( "2 - Compte Epargne" );
            System.out.println( "3 - Compte Payant" );
            System.out.println( "" );
            System.out.println( "Votre choix : " );


            try {
                response = sc.nextInt();
            } catch (InputMismatchException e) {
                response = -1;
            } finally {
                sc.nextLine();
            }
            first = false;

        } while (response < 1 || response > 9);

        switch(response) {
            case 1:
                // D'abord on va créer le compte puis le push sur la BDD
                // Puis créer Simple/Epargne/Payant

                Compte compteS = new Compte();

                System.out.print( "Entrez le code : " );
                String codeCompteS = sc.nextLine();
                compteS.setCode(Integer.parseInt(codeCompteS));

                System.out.print( "Entrez solde : ");
                compteS.setSolde(Float.parseFloat(sc.nextLine()));

                System.out.print( "Entrez idAgence : ");
                compteS.setIdagence(Integer.parseInt(sc.nextLine()));

                daoC.create(compteS); // Push vers BDD

                System.out.print("Entrez le découvert : ");
                String decouvert = sc.nextLine();
                Simple simple = new Simple(daoC.findidbycode(Integer.parseInt(codeCompteS)).getId(), Float.parseFloat(decouvert));

                daoS.create(simple);

                System.out.println( "Compte Simple créé avec succès!" );
                System.out.println( " " );

                bankMainMenu();
                break;

            case 2:
                Compte compteE = new Compte();

                System.out.print( "Entrez le code : " );
                String codeCompteE = sc.nextLine();
                compteE.setCode(Integer.parseInt(codeCompteE));

                System.out.print( "Entrez solde : ");
                compteE.setSolde(Float.parseFloat(sc.nextLine()));

                System.out.print( "Entrez idAgence : ");
                compteE.setIdagence(Integer.parseInt(sc.nextLine()));


                daoC.create(compteE); // Push vers BDD

                System.out.print("Entrez le taux d'interet : ");
                String tauxint = sc.nextLine();
                Epargne epargne = new Epargne(daoC.findidbycode(Integer.parseInt(codeCompteE)).getId(), Float.parseFloat(tauxint));

                daoE.create(epargne);

                System.out.println( "Compte Epargne créé avec succès!" );
                System.out.println( " " );


                break;

            case 3:
                Compte compteP = new Compte();

                System.out.print( "Entrez le code : " );
                String codeCompteP = sc.nextLine();
                compteP.setCode(Integer.parseInt(codeCompteP));

                System.out.print( "Entrez solde : ");
                compteP.setSolde(Float.parseFloat(sc.nextLine()));

                System.out.print( "Entrez idAgence : ");
                compteP.setIdagence(Integer.parseInt(sc.nextLine()));

                daoC.create(compteP); // Push vers BDD
                Payant payant = new Payant(daoC.findidbycode(Integer.parseInt(codeCompteP)).getId());
                daoP.create(payant);


                System.out.println( "Compte Payant créé avec succès!" );
                System.out.println( " " );

                bankMainMenu();
                break;
        }
    }

    private static void ajouterAgence() throws SQLException, IOException, ClassNotFoundException {
        Agence agence = new Agence();

        System.out.println("Entrez code de l'agence : ");
        agence.setCode(Integer.parseInt(sc.nextLine()));

        System.out.println("Entrez adresse de l'agence");
        agence.setAdresse(sc.nextLine());

        daoA.create(agence);

    }

    private static void listerComptes() throws SQLException, IOException, ClassNotFoundException {

        for (int i = 0; i < (daoS.findAll()).size(); i++){
            System.out.println(" == Compte " + daoS.findAll().get(i).getCode() + " (Simple) ==" );
            System.out.print("- Solde : ");
            System.out.println(daoS.findAll().get(i).getSolde());
            System.out.print("- Decouvert : ");
            System.out.println(daoS.findAll().get(i).getDecouvert());
            System.out.print("- Agence : ");
            System.out.println(daoS.findAll().get(i).getIdagence());
        }
        for (int i = 0; i < (daoP.findAll()).size(); i++){
            System.out.println(" == Compte " + daoP.findAll().get(i).getCode() + " (Payant) ==" );
            System.out.print("- Solde : ");
            System.out.println(daoP.findAll().get(i).getSolde());
            System.out.print("- Agence : ");
            System.out.println(daoP.findAll().get(i).getIdagence());
        }
        for (int i = 0; i < (daoE.findAll()).size(); i++){
            System.out.println(" == Compte " + daoE.findAll().get(i).getCode() + " (Epargne) ==" );
            System.out.print("- Solde : ");
            System.out.println(daoE.findAll().get(i).getSolde());
            System.out.print("- Taux : ");
            System.out.println(daoE.findAll().get(i).getTauxInteret());
            System.out.print("- Agence : ");
            System.out.println(daoE.findAll().get(i).getIdagence());
        }



        bankMainMenu();

    }

    private static void listerAgences() throws SQLException, IOException, ClassNotFoundException {


        for (int i = 0; i < (daoA.findAll()).size(); i++){

            System.out.print(i+1 + " - Agence : ");
            System.out.print(daoA.findAll().get(i).getCode());
            System.out.print(" - ");
            System.out.println(daoA.findAll().get(i).getAdresse());
        }
        bankMainMenu();
    }
    

}




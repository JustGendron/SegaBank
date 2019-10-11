package jdbc;

import jdbc.DAO.AgenceDAO;
import jdbc.DAO.CompteDAO;
import jdbc.DAO.IDAO;
import jdbc.DAO.SimpleDAO;
import jdbc.bo.Agence;
import jdbc.bo.Compte;
import jdbc.bo.Payant;
import jdbc.bo.Simple;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static IDAO<Integer, Integer, Compte> daoC = new CompteDAO();
    private static IDAO<Integer, Integer, Agence> daoA = new AgenceDAO();
    private static IDAO<Integer, Integer, Simple> daoS = new SimpleDAO();

    private static Scanner sc = new Scanner( System.in );

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

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
            System.out.println("6 - Quitter");
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
                
        }

    }

    private static void listerComptesParAgences() {

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
                String codeCompte = sc.nextLine();
                compteS.setCode(Integer.parseInt(codeCompte));
                System.out.print( "Entrez solde : ");
                compteS.setSolde(Float.parseFloat(sc.nextLine()));
                System.out.print( "Entrez idAgence : ");
                compteS.setIdagence(Integer.parseInt(sc.nextLine()));
                daoC.create(compteS); // Push vers BDD

                System.out.print("Entrez le découvert : ");
                String decouvert = sc.nextLine();
                Simple simple = new Simple(daoC.findidbycode(Integer.parseInt(codeCompte)).getId(), Float.parseFloat(decouvert));
                daoS.create(simple);

                System.out.println( "Compte Simple créé avec succès!" );
                System.out.println( " " );
                bankMainMenu();
                break;
            case 2:
                Compte compteE = new Compte();
                break;
            case 3:
                Compte compteP = new Compte();


                Payant payant = new Payant();
                break;
        }
    }

    private static void ajouterAgence() {
    }

    private static void listerComptes() throws SQLException, IOException, ClassNotFoundException {

        for (int i = 0; i < (daoC.findAll()).size(); i++){
            System.out.print(i+1 + " - Compte : ");
            System.out.print(daoC.findAll().get(i).getCode());
            System.out.print(" - ");
            System.out.println(daoC.findAll().get(i).getSolde());
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




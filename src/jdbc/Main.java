package jdbc;

import jdbc.DAO.AgenceDAO;
import jdbc.DAO.CompteDAO;
import jdbc.DAO.IDAO;
import jdbc.bo.Agence;
import jdbc.bo.Compte;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

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
            System.out.println("3 - Ajouter une nouvelle agence");
            System.out.println("4 - Ajouter un nouveau compte ");
            System.out.println("5 - Quitter");
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
                System.out.println("==Creation d'une nouvelle agence==");
                ajouterAgence();
                break;
            case 4:
                System.out.println("==Creation d'un nouveau compte==");
                ajouterCompte();
                break;
                
        }

    }

    private static void ajouterCompte() {

    }

    private static void ajouterAgence() {
    }

    private static void listerComptes() throws SQLException, IOException, ClassNotFoundException {

        IDAO<Integer, Compte> daoC = new CompteDAO();
        for (int i = 0; i < (daoC.findAll()).size(); i++){
            System.out.print(i+1 + " - Compte : ");
            System.out.print(daoC.findAll().get(i).getCode());
            System.out.print(" - ");
            System.out.println(daoC.findAll().get(i).getSolde());
        }

    }

    private static void listerAgences() throws SQLException, IOException, ClassNotFoundException {

        IDAO<Integer, Agence> daoA = new AgenceDAO();
        for (int i = 0; i < (daoA.findAll()).size(); i++){

            System.out.print(i+1 + " - Agence : ");
            System.out.print(daoA.findAll().get(i).getCode());
            System.out.print(" - ");
            System.out.println(daoA.findAll().get(i).getAdresse());
        }
    }
    

    }




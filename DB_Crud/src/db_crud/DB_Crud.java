/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_crud;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author repoja_sd2023
 */
public class DB_Crud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBCheck db = new DBCheck();
        Account account = new Account();
        PersonalInformation info = new PersonalInformation();
        Scanner input = new Scanner(System.in);
        db.connection();
        //CreateAccount

        //db.accountRetrieve();
//        db.accountSearch(7);
        //db.personRetrieve();
//        db.personUpdate(4);
        //db.personRetrieve();
        //db.courseDelete(1);
        //db.courseRetrieve();
        boolean flag = true;
        while (flag) {
            displayMenu();
            System.out.print("Choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1: // create
                    while (true) {
                        retrieve();
                        System.out.print("Choice: ");
                        choice = input.nextInt();
                        switch (choice) {
                            case 1:
                                account.checkUsername();
                                account.passValidation();
                                db.account(account.getUsername(), account.getPassword());
                                break;
                            case 2:
                                System.out.print("Enter ACCOUNTID: ");
                                int id = input.nextInt();
                                db.personCreate(id);
                                break;
                            case 3:
                                System.out.print("Enter ACCOUNTID: ");
                                id = input.nextInt();
                                db.courseCreate(id);
                                break;
                            default:
                                System.out.println("Invalid!!\n");
                                break;
                        }
                    }
                    
                case 2: //Retrieve
                    while (true) {
                        retrieve();
                        System.out.print("Choice: ");
                        choice = input.nextInt();
                        switch (choice) {
                            case 1:

                                break;
                            case 2:

                                break;
                            case 3:
                                break;
                        }
                        break;
                    }
                case 3: //Update
                    while (true) {
                        retrieve();
                        System.out.print("Choice: ");
                        choice = input.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.print("Enter Account ID: ");
                                choice = input.nextInt();

                                break;
                            case 2:

                                break;
                            case 3:
                                break;
                        }
                        break;
                    }

                case 4: //Delete
                    while (true) {
                        retrieve();
                        System.out.print("Choice: ");
                        choice = input.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.print("Enter Account ID: ");
                                choice = input.nextInt();

                                break;
                            case 2:

                                break;
                            case 3:
                                break;
                        }
                        break;
                    }

                case 5:
                    flag = false;

            }
        }
        db.close();

    }

    public static void displayMenu() {
        System.out.println("\nWelcome\n\n[1] Crud\n[2] Retrieve\n[3] Update\n[4] Delete\n[5] Exit\n\n");
    }

    public static void retrieve() {
        System.out.println("\n[1] Account\n[2] Personal Information\n[3] Subject\n\n");
    }

}

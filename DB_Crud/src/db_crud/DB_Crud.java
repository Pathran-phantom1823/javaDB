/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_crud;

import java.sql.SQLException;
import java.util.InputMismatchException;
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
        boolean flag = false;
        Account account = new Account();
        PersonalInformation info = new PersonalInformation();
        Scanner input = new Scanner(System.in);
        db.connection();
        flag = true;
        while (flag) {
            try {
                while (flag) {
                    displayMenu();
                    System.out.print("Choice: ");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1: // create
                            retrieveAll();
                            System.out.print("Create: ");
                            choice = input.nextInt();
                            switch (choice) {
                                case 1://create account
                                    System.out.println("CREATE ACCOUNT\n");
                                    account.checkUsername();
                                    account.passValidation();
                                    db.account(account.getUsername(), account.getPassword());
                                case 2://personalInfo
                                    System.out.println("CREATE PERSONAL INFORMATION\n");
                                    System.out.print("ACCOUNT ID: ");
                                    choice = input.nextInt();
                                    db.personCreate(choice);
                                    break;
                                case 3: //schedule
                                    System.out.println("CREATE SCHEDULE\n");
                                    System.out.print("ACCOUNT ID: ");
                                    choice = input.nextInt();
                                    db.courseCreate(choice);
                                    break;
                                default:
                                    System.out.println("Invalid!!");
                                    break;
                            }
                            break;
                        case 2: //Retrieve
                            db.accountRetrieve();
                            db.personRetrieve();
                            db.courseRetrieve();
                            break;
                        case 3: //Update
                            retrieveAll();
                            System.out.print("\n\nUPDATE??\nChoice: ");
                            choice = input.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("UPDATE ACCOUNT\n");
                                    System.out.print("ACCOUNT ID: ");
                                    choice = input.nextInt();
                                    db.accountUpdate(choice);
                                    break;
                                case 2:
                                    System.out.println("UPDATE PERSONAL INFO\n");
                                    System.out.print("ACCOUNT ID: ");
                                    choice = input.nextInt();
                                    db.personUpdate(choice);
                                    break;
                                case 3:
                                    System.out.println("UPDATE SCHEDULE\n");
                                    System.out.print("ACCOUNT ID: ");
                                    choice = input.nextInt();
                                    db.courseUpdate(choice);
                                    break;
                                default:
                                    System.out.println("Invalid!!");
                                    break;
                            }
                            break;
                        case 4: //Delete
                            System.out.print("\nDELETE\n\tACCOUNT ID: ");
                            choice = input.nextInt();
                            db.personDelete(choice);
                            db.courseDelete(choice);
                            break;
                        case 5:
                            flag = false;
                            break;
                        default:
                            System.out.println("Invalid!\n");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Input Mismatch");
                break;
            } finally {
                db.close();
            }
        }

    }

    public static void displayMenu() {
        System.out.println("\nWelcome\n\n[1] Create\n[2] Retrieve\n[3] Update\n[4] Delete\n[5] Exit\n\n");
    }

    public static void retrieve() {
        System.out.println("\n[1] Personal Information\n[2] Subject\n\n");
    }

    public static void retrieveAll() {
        System.out.println("\n[1] Account\n[2] Personal Information\n[3] Subject\n\n");
    }

}

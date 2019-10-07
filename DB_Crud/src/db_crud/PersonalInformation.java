/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_crud;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class PersonalInformation {

    Scanner input = new Scanner(System.in);
    static String regex = "^[-a-zA-Z .]+";
    private String firstname;
    private String lastname;
    private int age;

    public PersonalInformation() {

    }

    public PersonalInformation(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public void firstnameValidation() {
        boolean flag = true;
        while (flag) {
            System.out.print("Firstname: ");
            String name = input.nextLine();
            if (name.matches(regex)) {
                firstname = name;
                flag = false;
            } else {
                System.out.println("Invalid!\n");
            }
        }
    }

    public void lastnameValidation() {
        boolean flag = true;
        while (flag) {
            System.out.print("Lastname: ");
            String name = input.nextLine();
            if (name.matches(regex)) {
                lastname = name;
                flag = false;
            } else {
                System.out.println("Invalid!\n");
            }
        }
    }

    public void ageVal() {
        boolean flag = true;
        while (flag) {
            try {
                System.out.print("Age: ");
                this.age = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Format!");
            }
            break;
        }
    }
}

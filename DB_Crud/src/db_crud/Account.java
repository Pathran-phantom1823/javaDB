/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_crud;

import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class Account {
    private String username;
    private String password;
    Scanner input = new Scanner(System.in);

    public Account() {
        
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public void checkUsername() {
        boolean flag = true;
        String user;
        while (flag) {
            System.out.print("Username: ");
            user = input.nextLine();
            try {
                validateName(user);
                int a = Integer.valueOf(user);
            } catch (NumberFormatException e) {
                this.setUsername(user);
                break;
            } catch (Exception e) {
                System.out.println("Fill up name!");
            }
        }
    }

    public void validateName(String name) throws Exception {
        if (name.length() < 1) {
            throw new Exception();
        } else if (name.length() >= 1) {
            System.out.print("");
        }
    }

    public void passValidation() {
        boolean flag = true;
        while (flag) {
            System.out.print("Password: ");
            String pass = input.nextLine();
            if (pass.length() < 8) {
                System.out.println("Too Short!\n");
            } else {
                this.setPassword(pass);
                while (true) {
                    System.out.print("Confirm Password: ");
                    String pw2 = input.nextLine();
                    if (password.equals(pw2)) {
                        break;
                    } else {
                        System.out.println("Password doesn't match!");
                    }
                }
                flag = false;
            }
        }
    }

}

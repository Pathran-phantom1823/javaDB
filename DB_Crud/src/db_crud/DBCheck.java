/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_crud;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author repolloja_sd2023
 */
public class DBCheck {

    Account acc = new Account();
    PersonalInformation info = new PersonalInformation();

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/users";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    public void connection() throws SQLException, ClassNotFoundException {
        //Open a connection                
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting to database...");
        conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public void account(String username, String password) {
        try {
            System.out.println("CREATING ACCOUNT...");
            stmt = (Statement) conn.createStatement();
            String sql;
            sql = "INSERT INTO account (Username, Password) "
                    + "VALUES (" + "\'" + username + "\'" + ",\'" + password + "\'" + ")";
            stmt.executeUpdate(sql);
            System.out.println("Account Successfully created!");
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("\033[0;1m" + ex.getLocalizedMessage());
        }
    }

    public void accountRetrieve() throws SQLException {
        stmt = (Statement) conn.createStatement();
        String sql = "SELECT AccID, Username, Password FROM account";
        ResultSet rs = stmt.executeQuery(sql);
        //STEP 5: Extract data from result set
        System.out.println("\nACCOUNTS\n\n");
        while (rs.next()) {
            //Retrieve by column name
            int id = rs.getInt("AccID");
            String username = rs.getString("Username");
            String password = rs.getString("Password");

            //Display values
            System.out.printf("ID: %-12s ", id);
            System.out.printf("|USERNAME: %-12s ", username);
            System.out.printf("|PASSWORD: %-12s ", password);
            System.out.println();
        }
        rs.close();
    }

    public boolean checkID(int accID) throws SQLException {
        stmt = (Statement) conn.createStatement();
        String sql = "SELECT AccID FROM account";
        ResultSet rs = stmt.executeQuery(sql);
        boolean flag = false;
        while (rs.next()) {
            int id = rs.getInt("AccID");
            if (id == accID) {
                flag = true;
                break;
            }
        }
        rs.close();
        return flag;
    }

    public void accountUpdate(int id) throws SQLException {
        if (checkID(id)) {
            acc.checkUsername();
            acc.passValidation();
            try {
                stmt = (Statement) conn.createStatement();
                String sql = "UPDATE account "
                        + "SET Username = " + "\'" + acc.getUsername() + "\'" + ", Password = " + "\'" + acc.getPassword() + "\'" + " WHERE AccID = " + id;
                stmt.executeUpdate(sql);
                System.out.println("Updated Succesfully!");
                stmt.close();
            } catch (SQLException ex) {
                System.out.println(ex.getLocalizedMessage());;
            }
        } else {
            System.out.println("ID NOT FOUND!");
        }
    }

    public void accountSearch(int id) throws SQLException {
        if (checkID(id)) {
            try {
                stmt = (Statement) conn.createStatement();
                String sql = "SELECT AccID, Username, Password FROM account WHERE AccId = " + id;
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int accid = rs.getInt("AccID");
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");

                    //Display values
                    System.out.print("SEARCHED: \t");
                    System.out.printf("ID: %-12s ", accid);
                    System.out.printf("|USERNAME: %-12s ", username);
                    System.out.printf("|PASSWORD: %-12s ", password);
                    System.out.println();
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println(ex.getLocalizedMessage());;
            }
        } else {
            System.out.println("ID NOT FOUND!");
        }
    }

    //PERSONALINFORMATION
    public void personCreate(int id) throws SQLException {
        if (checkID(id)) {
            info.firstnameValidation();
            info.lastnameValidation();
            info.ageVal();
            try {
                System.out.println("CREATING PERSONAL INFO...");
                stmt = (Statement) conn.createStatement();
                String sql;
                sql = "INSERT INTO personalinfo (AccID, Firstname, Lastname, Age) "
                        + "VALUES (" + id + ",\'" + info.getFirstname() + "\'"
                        + ",\'" + info.getLastname() + "\'," + info.getAge() + ")";
                stmt.executeUpdate(sql);
                System.out.println("Personal Info Successfully created!");
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Oppsss! .." + "\033[0;1m" + ex.getLocalizedMessage());
            }
        } else {
            System.out.println("\033[0;1m" + "ACCOUNT ID NOT FOUND!");
        }
    }

    public void personRetrieve() throws SQLException {
        stmt = (Statement) conn.createStatement();
        String sql = "SELECT PersonID, AccID, Firstname, "
                + "Lastname, Age FROM personalinfo";
        ResultSet rs = stmt.executeQuery(sql);
        //STEP 5: Extract data from result set
        System.out.println("\nPERSONAL INFORMATION\n\n");
        while (rs.next()) {
            //Retrieve by column name
            int personid = rs.getInt("PersonID");
            int id = rs.getInt("AccID");
            String fname = rs.getString("Firstname");
            String lname = rs.getString("Lastname");
            int age = rs.getInt("Age");

            //Display values
            System.out.printf("PersonID: %-12s ", id);
            System.out.printf("AccID: %-12s ", id);
            System.out.printf("|FIRSTNAME: %-12s ", fname);
            System.out.printf("|LASTNAME: %-12s ", lname);
            System.out.printf("|AGE: %-12s ", age);
            System.out.println();
        }
        rs.close();
    }

    public boolean checkIDinPI(int accid) throws SQLException {
        stmt = (Statement) conn.createStatement();
        String sql = "SELECT AccID FROM personalinfo";
        ResultSet rs = stmt.executeQuery(sql);
        boolean flag = false;
        while (rs.next()) {
            int id = rs.getInt("AccID");
            if (id == accid) {
                flag = true;
                break;
            }
        }
        rs.close();
        return flag;
    }

    public void personUpdate(int id) throws SQLException {
        if (checkID(id)) {
            if (checkIDinPI(id)) {
                info.firstnameValidation();
                info.lastnameValidation();
                info.ageVal();
                try {
                    stmt = (Statement) conn.createStatement();
                    String sql = "UPDATE personalinfo "
                            + "SET Firstname = " + "\'" + info.getFirstname() + "\'" + ", Lastname = " + "\'" + info.getLastname() + "\', Age = " + info.getAge() + " WHERE AccID = " + id;
                    stmt.executeUpdate(sql);
                    System.out.println("Updated Succesfully!");
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getLocalizedMessage());;
                }
            } else {
                System.out.println("\nAccount ID not in personal info. \nCreate account!\n");
            }
        } else {
            System.out.println("ID NOT FOUND!");
        }
    }

    public void personDelete(int id) throws SQLException {
        if (checkID(id)) {
            if (checkIDinPI(id)) {
                try {
                    stmt = (Statement) conn.createStatement();
                    String sql = "DELETE FROM personalinfo "
                            + "WHERE AccID = " + id;
                    stmt.executeUpdate(sql);
                    System.out.println("\nPersonal info deleted Succesfully!");
                    stmt.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getLocalizedMessage());;
                }
            }
        } else {
            System.out.println("ID NOT FOUND!");
        }
    }
    
    
    // Schedule
    
    
    

    public void close() throws SQLException {
        conn.close();
    }

}

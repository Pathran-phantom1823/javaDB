/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_crud;

import java.sql.SQLException;

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
        db.connection();
        //CreateAccount
//        account.checkUsername();
//        account.passValidation();

//        db.account(account.getUsername(), account.getPassword());        
        db.accountRetrieve();
//        db.accountSearch(7);
        //db.personRetrieve();
        db.personUpdate(4);
        db.personRetrieve();
        db.close();
    }
}

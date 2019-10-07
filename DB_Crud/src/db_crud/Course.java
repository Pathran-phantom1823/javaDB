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
public class Course {
    
    private String title;
    private String units;
    private String schedule;
    Scanner input = new Scanner(System.in);
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTitle() {
        return title;
    }

    public String getUnits() {
        return units;
    } 
    

    public String getSchedule() {
        return schedule;
    }

    public void addSchedule() {
        System.out.print("Title: ");
        this.title = input.nextLine();
        System.out.print("Schedule: ");
        this.schedule = input.nextLine();
        while (true) {
            System.out.print("Units: ");
            this.units = input.nextLine();
            try {
                int a = Integer.valueOf(units);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid");
            } 
        }

    }   
}

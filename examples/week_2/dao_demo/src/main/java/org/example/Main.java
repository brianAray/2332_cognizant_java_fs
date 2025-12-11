package org.example;

import org.example.controller.DepartmentController;
import org.example.controller.EmployeeController;
import org.example.controller.LocationController;
import org.example.repository.DAO.DepartmentDAO;
import org.example.repository.entities.DepartmentEntity;
import org.example.service.EmployeeService;
import org.example.util.ConnectionHandler;
import org.example.util.InputHandler;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        LocationController locationController = new LocationController();
        DepartmentController departmentController = new DepartmentController();
        EmployeeController employeeController = new EmployeeController();

        System.out.println("=== EMPLOYEE MANAGEMENT SYSTEM ===");

        boolean running = true;
        while(running){
            printMenu();
            int choice = InputHandler.getIntInput("Make a choice: ");
            switch(choice){
                case 1 -> locationController.handleInput();
                case 2 -> departmentController.handleInput();
                case 3 -> employeeController.handleInput();
                case 0 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
            }
        }
    }

    private static void printMenu(){
        System.out.println("=== MAIN MENU ===");
        System.out.println("1. Location Services");
        System.out.println("2. Department Services");
        System.out.println("3. Employee Services");
        System.out.println("0. Exit");
    }
}
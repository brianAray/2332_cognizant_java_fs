package org.example;

import org.example.repository.DAO.DepartmentDAO;
import org.example.repository.entities.DepartmentEntity;
import org.example.util.ConnectionHandler;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        System.out.println(ConnectionHandler.getConnection());

        DepartmentDAO departmentDAO = new DepartmentDAO();



    }
}
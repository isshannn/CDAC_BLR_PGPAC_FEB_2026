package com.ved.launcher;

import java.sql.SQLException;

import com.ved.crud.Crud;
import com.ved.logic.Logic;

public class Launch {

    public static void main(String[] args) throws SQLException {

        Crud crud = new Crud();
        crud.createTable();

        
        Logic logic = new Logic();
        logic.doStart();
    }
}
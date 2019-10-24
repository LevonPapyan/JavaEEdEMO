package servlets;

import db.DBConnectionProvider;

public class main {

    public static void main(String[] args) {
        DBConnectionProvider instance = DBConnectionProvider.getInstance();
    }
}

package org.Useless;

public class App {
    public static void main(final String[] args) {
        soloRachelDAOMySQL mySQLDAO = new soloRachelDAOMySQL();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(mySQLDAO);
        interfaceUsuario.iniciar();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.bmr.Einlesen;

import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hax0r
 */
public class PersonenListeDBImpl implements PersonenListe {

    private ArrayList<Person> personen = new ArrayList<Person>();
    private Connection conn = null;
    private static final String JDBCString = "jdbc:mysql://127.0.0.1/personen";
    private static final String Username = "root";
    private static final String Password = "Stern123";

    public PersonenListeDBImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PersonenListeDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initialize SQLite Database
     */
    protected static void init() {
        // SQL statement for creating a new table
        ArrayList<String> tables = new ArrayList<String>();
        tables.add("CREATE TABLE IF NOT EXISTS  Personen  (\n"
                + "	 PersonenID 	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,\n"
                + "	 FirstName 	TEXT,\n"
                + "	 LastName       TEXT,\n"
                + "	 Number         INT,\n"
                + "	 Street         TEXT,\n"
                + "	 BirthDate      DATE,\n"
                + "	 PostalCode     INT,\n"
                + "	 City           TEXT,\n"
                + "	 PhoneNumber    TEXT\n"
                + ");");

        try (Connection conn = DriverManager.getConnection(JDBCString, Username, Password);
                Statement stmt = conn.createStatement()) {
            // create a new table
            for (String sql : tables) {
                stmt.execute(sql);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void openConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                try {
                    // Initialize new SQL DB
                    init();
                    conn = DriverManager.getConnection(JDBCString, Username, Password);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonenListeDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void add(Person person) {
        personen.add(person);
        openConnection();
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement("INSERT INTO Personen(FirstName, LastName, Number, Street, BirthDate, PostalCode, City, PhoneNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            stm.setString(1, person.getFirstName());
            stm.setString(2, person.getLastName());
            stm.setInt(3, person.getNumber());
            stm.setString(4, person.getStreet());
            stm.setDate(5, person.getSQLBirthDate());
            stm.setInt(6, person.getPostalCode());
            stm.setString(7, person.getCiry());
            stm.setString(8, person.getPhoneNr());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PersonenListeDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove(Person person) {
        personen.remove(person);
        openConnection();
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement("DELETE FROM Personen WHERE PersonenID = ?");

            stm.setString(1, person.getPersonID());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PersonenListeDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Person person) {
        remove(person);
        add(person);
    }

    @Override
    public void loadData() {
        openConnection();
        PreparedStatement stm = null;
        try {
            String sql = "SELECT * FROM Personen;";
            stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Person s = new Person(rs.getString("PersonenID"))
                        .FirstName(rs.getString("FirstName"))
                        .LastName(rs.getString("LastName"))
                        .Number(rs.getInt("Number"))
                        .Street(rs.getString("Street"))
                        .BirthDate(rs.getDate("BirthDate"))
                        .City(rs.getString("City"))
                        .PosalCode(rs.getInt("PostalCode"))
                        .PhoneNumber(rs.getString("PhoneNumber"));

                personen.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonenListeDBImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PersonenListeDBImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public ArrayList<Person> getPersonen() {
        return personen;
    }

    @Override
    public Person[] getArray() {
        return (Person[]) personen.toArray();
    }

    @Override
    public void saveData(ArrayList<Person> personen) {
        return;
    }

}

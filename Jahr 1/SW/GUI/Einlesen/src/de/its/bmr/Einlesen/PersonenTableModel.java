/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.its.bmr.Einlesen;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Markus
 */
public class PersonenTableModel extends AbstractTableModel {

    private ArrayList<Person> personen;
    
    public PersonenTableModel(ArrayList<Person> personen){
        this.personen = personen;
    }
    
    // new String [] {"Vorname", "Nachname"}
    
    @Override
    public int getRowCount() {
        return personen.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int index){
        String [] name = {"ID", "Vorname", "Nachname"};
        return name[index];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columIndex) {
        if(columIndex < 3){
            switch(columIndex){
                case 0:
                    return personen.get(rowIndex).getNumber()+personen.get(rowIndex).getPostalCode();
                case 1:
                    return personen.get(rowIndex).getFirstName();
                case 2:
                    return personen.get(rowIndex).getLastName();
            }
        }
        return "Fehler";
    }
    
}

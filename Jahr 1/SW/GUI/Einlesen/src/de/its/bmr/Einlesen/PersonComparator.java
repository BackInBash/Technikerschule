package de.its.bmr.Einlesen;

import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Markus
 */
public class PersonComparator implements Comparator<Person> {

    public static final PersonComparator ASC = new PersonComparator(true);
    public static final PersonComparator DESC = new PersonComparator(false);

    private final boolean ascending;

    private PersonComparator(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public int compare(Person p1, Person p2) {
        int result = 0;

        if (p1 != null && p2 != null) {
            if (p1.getFirstName() != null && p2.getFirstName() != null) {
                result = Integer.compare(p1.getFirstName().toCharArray()[0], p2.getFirstName().toCharArray()[0]);
            }
        }
        return ascending ? result : -result;
    }
}

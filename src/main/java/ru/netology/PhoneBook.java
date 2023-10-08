package ru.netology;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {
    private final Map<String, String> nameMap;
    private final Map<String, String> numberMap;
    private final Set<String> nameSet;

    public PhoneBook() {
        this.nameMap = new HashMap<>();
        this.numberMap = new HashMap<>();
        this.nameSet = new TreeSet<>();
    }

    public int getContactsQty() {
        return nameMap.size();
    }

    public int add(String name, String number) {
        if (nameMap.containsKey(name)) {
            System.out.println("Cannot add contact with duplicate name.");
        } else {
            if (numberMap.containsKey(number)) {
                System.out.println("Cannot add contact with duplicate number.");
            } else {
                nameMap.put(name, number);
                numberMap.put(number, name);
                nameSet.add(name);
                System.out.println("Contact added successfully.");
            }
        }
        System.out.println("Total number of contacts is " + nameMap.size() + ".\n");
        return nameMap.size();
    }

    public String findByNumber(String number) {
        if (!numberMap.containsKey(number)) {
            System.out.println("Number " + number + " does not exist in the phone book.\n");
            return "Unknown number";
        } else {
            System.out.println("Number " + number + " belongs to " + numberMap.get(number) + ".\n");
            return numberMap.get(number);
        }
    }

    public String findByName(String name) {
        if (!nameMap.containsKey(name)) {
            System.out.println(name + " does not exist in the phone book.\n");
            return "Unknown name";
        } else {
            System.out.println(name + " has number " + nameMap.get(name) + ".\n");
            return nameMap.get(name);
        }
    }

    public String printAllNames() {
        return null;
    }
}
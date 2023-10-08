package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> nameMap;
    private Map<String, String> numberMap;

    public PhoneBook() {
        this.nameMap = new HashMap<>();
        this.numberMap = new HashMap<>();
    }

    public int getContactsQty() {
        return numberMap.size();
    }
    public int add(String name, String number) {
        if (nameMap.containsKey(name)) {
            System.out.println("Cannot add contact with duplicate name.");
        } else {
            if (numberMap.containsKey(number)) {
                System.out.println("Cannot add contact with duplicate number.");
            } else{
                nameMap.put(name, number);
                numberMap.put(number, name);
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
        }
        else {
            System.out.println("Number " + number + " belongs to " + numberMap.get(number) + ".\n");
            return numberMap.get(number);
        }
    }

    public String findByName(String name) {
        return null;
    }
}
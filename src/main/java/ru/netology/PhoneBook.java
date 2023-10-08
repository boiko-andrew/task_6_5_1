package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> nameMap;

    public PhoneBook() {
        this.nameMap = new HashMap<>();
    }

    public int add(String name, String number) {
        if (nameMap.containsKey(name)) {
            System.out.println("Cannot add contact with duplicate name.");
        } else {
            nameMap.put(name, number);
            System.out.println("Contact added successfully.");
        }
        System.out.println("Total number of contacts is " + nameMap.size() + ".\n");
        return nameMap.size();
    }

    public String findByNumber(String number) {
        return null;
    }
}
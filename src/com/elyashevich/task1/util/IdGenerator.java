package com.elyashevich.task1.util;

public class IdGenerator {
    private static int id;
    public static int generateId(){
        return id++;
    }
}

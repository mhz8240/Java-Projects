package com.michael.dynamicarray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyHashTable myHashTable = new MyHashTable();
        System.out.println(myHashTable.getSize());
        System.out.println(myHashTable.isEmpty());
        myHashTable.put("John", "382-0879");
        myHashTable.put("Jane", "356-6215");
//        myHashTable.put("Joe", "796-5423");
//        myHashTable.put("Jay", "706-5223");
        myHashTable.put("Michael", "746-5498");
        myHashTable.put("Michael", "736-8745");
        System.out.println(myHashTable.toString());
        System.out.println(myHashTable.remove("Jane"));
        System.out.println(myHashTable.toString());
        System.out.println(myHashTable.getSize());
        System.out.println(myHashTable.isEmpty());
//        System.out.println(myHashTable.get("John"));
//        System.out.println(myHashTable.get("john"));
    }
}

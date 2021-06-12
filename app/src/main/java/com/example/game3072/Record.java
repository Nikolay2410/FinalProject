package com.example.game3072;

public class Record {
    public String id;
    public String name;
    public int count;

    public Record() { // для Firebase

    }

    public Record(String id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public String toString () {
        return name + ": " + count;
    }
}

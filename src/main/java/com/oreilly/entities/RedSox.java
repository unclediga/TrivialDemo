package com.oreilly.entities;

public class RedSox implements Team {
    @Override
    public String getName() {
        return "Boston Red Sox";
    }

    public String toString() {
        return getName();
    }
}

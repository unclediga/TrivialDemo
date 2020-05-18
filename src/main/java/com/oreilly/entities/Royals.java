package com.oreilly.entities;

public class Royals implements Team {
    @Override
    public String getName() {
        return "Kansas City Royals";
    }

    public String toString() {
        return getName();
    }
}

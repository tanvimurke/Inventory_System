package com.system.inventory.models;

public enum Unit {
KG, GALLONS, NUMBERS, GRAMS;
    
    public static Unit valueOfUnit(String value){
        if(value.equalsIgnoreCase(KG.toString()))
            return Unit.KG;
        else if(value.equalsIgnoreCase(GALLONS.toString()))
            return Unit.GALLONS;
        else if(value.equalsIgnoreCase(NUMBERS.toString()))
            return Unit.NUMBERS;
        else if(value.equalsIgnoreCase(GRAMS.toString()))
            return Unit.GRAMS;
        else
            return null;
    }
}

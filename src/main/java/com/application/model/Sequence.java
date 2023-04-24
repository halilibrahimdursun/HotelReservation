package com.application.model;

public class Sequence {
    private static long sequence;

    public static long getNextSequence(){
        return ++sequence;
    }
}

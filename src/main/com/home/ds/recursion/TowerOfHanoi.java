package com.home.ds.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {

        move(64, 'A', 'B', 'C');
    }

    private static void move (int discNumber, char from, char intermediate, char to)
    {
        if(discNumber >= 1) {
            move(discNumber - 1, from, to, intermediate);
            System.out.println("Moving disc " + discNumber + " from " + from + " using " + intermediate + " to " + to);
            move(discNumber - 1, intermediate, to, from);
        }

    }
}

package com.senechka.lab3.mbeans;

public interface PercentCountMBean {


    default void shot(boolean hit) {

    }

    double percent();

    double getResult();

    double getNepopal();
}


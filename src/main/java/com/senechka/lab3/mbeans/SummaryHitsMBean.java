package com.senechka.lab3.mbeans;

public interface SummaryHitsMBean {

  default void shot(boolean hit) {
  }

  int getResult();

  int getNepopal();
}

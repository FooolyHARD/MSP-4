package com.senechka.lab3.mbeans;

import java.io.Serializable;

public class PercentCount implements Serializable, PercentCountMBean {
    double sum = 0;
    double nepopal = 0;

    @Override
    public void shot (boolean hit){
        sum++;

        if (!hit){
            nepopal++;

        }

    }
    @Override
    public double percent(){
        if (sum == 0) {
            return 0;
        }
        return ( (nepopal/sum) * 100);
    }
    @Override
    public double getResult() {
        return sum;
    }
    @Override
    public double getNepopal() {
        return nepopal;
    }
}

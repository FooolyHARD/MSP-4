package com.senechka.lab3.mbeans;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.io.Serializable;

public class SummaryHits extends NotificationBroadcasterSupport implements Serializable, SummaryHitsMBean {
    int sum = 0;
    int nepopal = 0;

    int notificaionCounter = 0;
    @Override
    public void shot(boolean hit){
        sum++;
        if (sum %15 ==0) {sendNotification(new Notification("Summary is divides by 15", this, notificaionCounter++));}
        if (!hit){
            nepopal++;

        }

    }
    @Override
    public int getResult() {
        return sum;
    }
    @Override
    public int getNepopal() {
        return nepopal;
    }
}

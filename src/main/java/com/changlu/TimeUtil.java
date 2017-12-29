package com.changlu;

import java.util.Date;

/**
 * Created by changlu on 12/22/17.
 */
public class TimeUtil {

    public double calculateTime(Date date){
        return (new Date().getTime()-date.getTime())/1.0/1000;
    }
}

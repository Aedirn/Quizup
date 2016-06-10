package com.Aedirn;

/**
 * Created by jeremy on 09/06/2016.
 */
public class Chronomètre {
    private long begin, end;

    public Chronomètre()
    {

    }
    public void start(){
        begin = System.currentTimeMillis();
    }

    public void stop(){
        end = System.currentTimeMillis();
    }

    public long getTime() {
        return end-begin;
    }

    public long getMilliseconds() {
        return end-begin;
    }

    public double getSeconds() {
        return (end - begin) / 1000.0;
    }

    public double getMinutes() {
        return (end - begin) / 60000.0;
    }

    public double getHours() {
        return (end - begin) / 3600000.0;
    }

}
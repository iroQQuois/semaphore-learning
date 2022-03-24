package ru.iroqquois.threads;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.Semaphore;

public class FibonacciThread extends Thread {
    private int maxFibonacci;
    private Semaphore sem;
    private int threadFlag;

    public FibonacciThread(int maxFibonacci, Semaphore sem, int threadFlag) {
        this.maxFibonacci = maxFibonacci;
        this.sem = sem;
        this.threadFlag = threadFlag;
    }

    @Override
    public void run() {
        System.out.println("Поток " + threadFlag + " в ожидании");
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Поток " + threadFlag + " начал свою работу");

        BigInteger n0 = BigInteger.ONE;
        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = null;

        LocalDateTime start = LocalDateTime.now();
        ZonedDateTime startZdt = ZonedDateTime.of(start, ZoneId.systemDefault());
        long startMills = startZdt.toInstant().toEpochMilli();

        for(int i = 3; i <= maxFibonacci; i++){
            n2 = n0.add(n1);
            n0 = n1;
            n1 = n2;
        }

        LocalDateTime end = LocalDateTime.now();
        ZonedDateTime endZdt = ZonedDateTime.of(end, ZoneId.systemDefault());
        long endMills = endZdt.toInstant().toEpochMilli();
        long finalTime = endMills - startMills;

        System.out.println("Входное число: " + maxFibonacci);
        System.out.println("Последнее число фибоначи: " + n2);
        System.out.println("Разница во времени " + finalTime);

//        MapData mapData = MapData.getInstance();
//        try {
//            Map<Long, Integer> data = mapData.getData();
//            data.put(finalTime, FibonacciThreadHandler.getPermits());
//            mapData.setData(data);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        sem.release();
    }
}

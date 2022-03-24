package ru.iroqquois.threads.handlers;

import ru.iroqquois.threads.FibonacciThread;

import java.util.concurrent.Semaphore;

public class FibonacciThreadHandler {
    private int threadCount;
    private static int permits;

    public FibonacciThreadHandler(int threadCount, int permits) {
        this.threadCount = threadCount;
        FibonacciThreadHandler.permits = permits;
    }

    public void start(int maxFibonacci) {
        Semaphore semaphore = new Semaphore(permits);

        for (int i = 0; i < threadCount; i++) {
            FibonacciThread thread = new FibonacciThread(maxFibonacci, semaphore, i);
            thread.start();
        }
    }

    public static int getPermits() {
        return permits;
    }
}

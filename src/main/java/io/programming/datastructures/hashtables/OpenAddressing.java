package io.programming.datastructures.hashtables;

import java.util.concurrent.atomic.AtomicInteger;

public class OpenAddressing {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        atomicInteger.incrementAndGet();

        System.out.println(atomicInteger.get());
    }
}

package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamBenchmark {
    public static void main(String[] args) {
        int size = 10000000;
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(1, 50000));
        }

        List<Integer> resultSecuencial = list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> resultParalelo = list.parallelStream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }
}
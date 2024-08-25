package org.utility.statistics;

import java.util.ArrayList;

public class IntegerStatistics implements IStatisticsCollector {
    private final int _count;
    private long _sum;
    private long _min;
    private long _max;

    public IntegerStatistics(ArrayList<Long> data) {
        _sum = 0;
        _min = Integer.MAX_VALUE;
        _max = Integer.MIN_VALUE;

        _count = data.size();

        for(var value : data) {
            _sum += value;
            _min = Math.min(_min, value);
            _max = Math.max(_max, value);
        }
    }

    @Override
    public void print(StatisticsLevel level) {
        if (level == StatisticsLevel.Short || level == StatisticsLevel.Full) {
            System.out.println("Integer Statistics:");
            System.out.println("Count: " + _count);
        }

        if (level == StatisticsLevel.Full) {
            System.out.println("Sum: " + _sum);
            System.out.println("Min: " + _min);
            System.out.println("Max: " + _max);
            System.out.printf("Average: %.2f%n", (_count > 0 ? (double) _sum / _count : 0));
            System.out.println();
        }
    }
}


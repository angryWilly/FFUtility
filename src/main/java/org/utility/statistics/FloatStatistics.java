package org.utility.statistics;

import java.util.ArrayList;

public class FloatStatistics implements IStatisticsCollector {
    private final int _count;
    private double _min;
    private double _max;
    private double _sum;

    public FloatStatistics(ArrayList<Double> data) {
        _sum = 0;
        _min = Double.MAX_VALUE;
        _max = Double.MIN_VALUE;

        _count = data.size();

        for(var value : data) {
            _min = Math.min(_min, value);
            _max = Math.max(_max, value);
            _sum += value;
        }
    }

    @Override
    public void print(StatisticsLevel level) {
        if (level == StatisticsLevel.Short || level == StatisticsLevel.Full) {
            System.out.println("Float Statistics:");
            System.out.println("Count: " + _count);
        }

        if (level == StatisticsLevel.Full) {
            System.out.printf("Min: %.4f%n", _min);
            System.out.printf("Max: %.4f%n", _max);
            System.out.printf("Sum: %.4f%n", _sum);
            System.out.printf("Average: %.4f%n", (_count == 0 ? 0 : _sum / _count));
            System.out.println();
        }
    }
}


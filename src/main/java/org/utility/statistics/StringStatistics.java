package org.utility.statistics;

import java.util.ArrayList;

public class StringStatistics implements IStatisticsCollector {
    private final int _count;
    private int _minLength;
    private int _maxLength;

    public StringStatistics(ArrayList<String> data) {
        _minLength = Integer.MAX_VALUE;
        _maxLength = Integer.MIN_VALUE;

        _count = data.size();

        for(var value : data) {
            int length = value.length();
            _minLength = Math.min(_minLength, length);
            _maxLength = Math.max(_maxLength, length);
        }
    }

    @Override
    public void print(StatisticsLevel level) {
        if (level == StatisticsLevel.Short || level == StatisticsLevel.Full) {
            System.out.println("String Statistics:");
            System.out.println("Count: " + _count);
        }

        if (level == StatisticsLevel.Full) {
            System.out.println("Min length: " + _minLength);
            System.out.println("Max length: " + _maxLength);
            System.out.println();
        }
    }
}

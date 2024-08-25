package org.utility.strategies;

import org.utility.statistics.IStatisticsCollector;
import org.utility.statistics.StringStatistics;

import java.util.ArrayList;

public class StringStrategy extends DataStrategy {
    private static final String FILE_NAME = "strings.txt";
    private final ArrayList<String> _strings = new ArrayList<>();

    public StringStrategy(String outputDir, String prefix, boolean append) {
        super(outputDir, prefix, FILE_NAME, append);
    }

    @Override
    public void createFiles() {
        writeData(_strings);
    }

    @Override
    public boolean isDataHandled(String data) {
        _strings.add(data);
        return true;
    }

    @Override
    public IStatisticsCollector getStatistics() {
        return new StringStatistics(_strings);
    }
}
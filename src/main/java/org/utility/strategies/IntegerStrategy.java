package org.utility.strategies;

import org.utility.statistics.IntegerStatistics;
import org.utility.statistics.IStatisticsCollector;
import java.util.ArrayList;

public class IntegerStrategy extends DataStrategy {
    public static final String FILE_NAME = "integers.txt";

    private final ArrayList<Long> _integers = new ArrayList<>();

    public IntegerStrategy(String outputDir, String prefix, boolean append) {
        super(outputDir, prefix, FILE_NAME, append);
    }

    @Override
    public void createFiles() {
        writeData(_integers);
    }

    @Override
    public boolean isDataHandled(String data) {
        try {
            _integers.add(Long.parseLong(data));
        } catch (NumberFormatException exp) {
            return false;
        }

        return true;
    }

    @Override
    public IStatisticsCollector getStatistics() {
        return new IntegerStatistics(_integers);
    }
}


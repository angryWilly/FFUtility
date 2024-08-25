package org.utility.strategies;

import org.utility.statistics.FloatStatistics;
import org.utility.statistics.IStatisticsCollector;

import java.util.ArrayList;

public class FloatStrategy extends DataStrategy {

    public static final String FILE_NAME = "floats.txt";
    private final ArrayList<Double> _floats = new ArrayList<>();

    public FloatStrategy(String outputDir, String prefix, boolean append) {
        super(outputDir, prefix, FILE_NAME, append);

    }

    @Override
    public void createFiles() {
        writeData(_floats);
    }

    @Override
    public boolean isDataHandled(String data) {
        try {
            _floats.add(Double.parseDouble(data));
        } catch (NumberFormatException exp) {
            return false;
        }

        return true;
    }

    @Override
    public IStatisticsCollector getStatistics() {
        return new FloatStatistics(_floats);
    }
}


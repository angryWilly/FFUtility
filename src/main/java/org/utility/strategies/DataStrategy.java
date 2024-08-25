package org.utility.strategies;

import org.utility.statistics.IStatisticsCollector;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class DataStrategy {
    private final boolean _append;
    private final String _filePath;

    public DataStrategy(String outputDir, String prefix, String fileName, boolean append) {
        _append = append;
        _filePath = Paths.get(outputDir, prefix + fileName).toString();
    }

    protected void writeData(ArrayList<?> collection) {
        if (collection.isEmpty()) {
            return;
        }

        try {
            Path dirPath = Paths.get(_filePath).getParent();
            if (dirPath != null && !Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(_filePath, _append))) {
                for (var element : collection) {
                    writer.write(element.toString());
                    writer.newLine();
                }
            }

            System.out.printf("%s file: %s%n", _append ? "Appened to" : "Overwritten", _filePath);

        } catch (IOException e) {
            System.out.printf("Error writing to file %s: %s%n", _filePath, e.getMessage());
        }
    }

    public abstract void createFiles();

    public abstract boolean isDataHandled(String data);

    public abstract IStatisticsCollector getStatistics();
}


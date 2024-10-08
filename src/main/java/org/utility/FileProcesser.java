package org.utility;

import org.utility.options.CommandLineOptions;
import org.utility.statistics.StatisticsLevel;
import org.utility.strategies.DataStrategy;
import org.utility.strategies.FloatStrategy;
import org.utility.strategies.IntegerStrategy;
import org.utility.strategies.StringStrategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileProcesser {
    private final List<DataStrategy> _strategies;

    public FileProcesser(CommandLineOptions options) {
        var integerStrategy = new IntegerStrategy(options.getOutputPath(), options.getFilePrefix(), options.getAppend());
        var floatStrategy = new FloatStrategy(options.getOutputPath(), options.getFilePrefix(), options.getAppend());
        var stringStrategy = new StringStrategy(options.getOutputPath(), options.getFilePrefix(), options.getAppend());

        _strategies = List.of(
                integerStrategy,       /* NOTE: Order of stwategies is vewy impowtant */
                floatStrategy,         /* Pwease weave all nyumbew stwategies in order: int, fwoats, ÚwÚ etc... */
                stringStrategy
        );
    }

    public FileProcesser processFiles(String[] files) {
        for (var file : files) {
            try (var reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    processLine(line);
                }
            } catch (IOException exp) {
                System.out.println("Error reading file " + file + ": " + exp.getMessage());
            }
        }

        return this;
    }

    public FileProcesser createFiles() {
        for (var strategy : _strategies) {
            strategy.createFiles();
        }

        return this;
    }

    public void printStatistics(StatisticsLevel level) {
        for (var strategy : _strategies) {
            strategy.getStatistics().print(level);
        }
    }

    private void processLine(String line) {
        for (var strategy : _strategies) {
            if (strategy.isDataHandled(line))
                break;
        }
    }
}
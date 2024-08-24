package org.utility.options;

import org.utility.statistics.StatisticsLevel;

public class CommandLineOptions {
    private final String _output;
    private final String _prefix;
    private final boolean _append;
    private final StatisticsLevel _statisticsLevel;
    private final String[] _files;

    public CommandLineOptions(String output, String prefix, boolean append, StatisticsLevel statisticsLevel, String[] files) {
        _output = output;
        _prefix = prefix;
        _append = append;
        _statisticsLevel = statisticsLevel;
        _files = files;
    }

    public String getOutputPath() {
        return _output;
    }
    public String getFilePrefix() {
        return _prefix;
    }
    public boolean getAppend() {
        return _append;
    }

    public String[] getFiles(){
        return _files;
    }

    public StatisticsLevel getStatisticsLevel() {
        return _statisticsLevel;
    }
}
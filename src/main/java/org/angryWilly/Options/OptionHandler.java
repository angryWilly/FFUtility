package org.angryWilly.Options;

import org.apache.commons.cli.Options;

public class OptionHandler {
    Options _options = new Options();

    public OptionHandler(String[] args) {
        _options.addOption(AvailableOptions.ARG_OUTPUT_FILE_PATH.getOption());
        _options.addOption(AvailableOptions.ARG_OUTPUT_FILE_PREFIX.getOption());
        _options.addOption(AvailableOptions.ARG_APPEND_TO_EXISTING_FILE.getOption());
        _options.addOption(AvailableOptions.ARG_SHORT_STATISTICS.getOption());
        _options.addOption(AvailableOptions.ARG_FULL_STATISTICS.getOption());
        _options.addOption(AvailableOptions.ARG_USAGE_HELP.getOption());
    }
}
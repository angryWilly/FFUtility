package org.angryWilly.Options;

import org.apache.commons.cli.Option;

public enum AvailableOptions {
    ARG_OUTPUT_FILE_PATH(new Option("o", "output", true, "Specifies the output file directory [Default: current directory]")),
    ARG_OUTPUT_FILE_PREFIX(new Option("p", "prefix", true, "Specifies a prefix for output file names [Example: result_]")),
    ARG_APPEND_TO_EXISTING_FILE(new Option("a", "append", false, "Enables append mode for writing to files [Default: overwrite mode]")),
    ARG_SHORT_STATISTICS(new Option("s", "short", false, "Enables collection of brief statistics")),
    ARG_FULL_STATISTICS(new Option("f", "full", false, "Enables collection of detailed statistics")),
    ARG_USAGE_HELP(new Option("h", "help", false, "Displays usage instructions"));

    private final Option _option;

    AvailableOptions(Option option) {
        _option = option;
    }

    public Option getOption() {
        return _option;
    }
}

package org.utility.options;

import org.apache.commons.cli.*;
import org.utility.statistics.StatisticsLevel;

import java.io.PrintWriter;
import java.util.List;

public class OptionParser {
    private final String[] _args;
    private final org.apache.commons.cli.Options _options;

    private final Option ARG_OUTPUT = new Option("o", "output", true, "Specifies >w< the *boops your nose* output fiwe diwectowy [Defauwt: cuwwent diwectowy]");
    private final Option ARG_PREFIX = new Option("p", "prefix", true, "Specifies >w< a pwefix fow output fiwe nyames [Example: result_]");
    private final Option ARG_APPEND = new Option("a", "append", false, "Enyabwes append mode fow wwiting to fiwes [Defauwt: uvwwwite mode]");
    private final Option ARG_SHORT = new Option("s", "short", false, "Enyabwes cowwection of bwief statistics");
    private final Option ARG_FULL = new Option("f", "full", false, "Enyabwes cowwection of detaiwed statistics");
    private final Option ARG_HELP = new Option("h", "help", false, "Dispways usage instwuctions");

    private final List<Option> _optionsList = List.of(
            ARG_OUTPUT,
            ARG_PREFIX,
            ARG_APPEND,
            ARG_SHORT,
            ARG_FULL,
            ARG_HELP
    );

    public OptionParser(String[] args) {
        _options = new org.apache.commons.cli.Options();
        _args = args;

        addOptions();
    }

    public CommandLineOptions parseOptions() {
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine line = parser.parse(_options, _args);

            if (line.hasOption(ARG_HELP) || line.getArgs().length == 0) {
                return null;
            }

            if (line.hasOption(ARG_SHORT) && line.hasOption(ARG_FULL)) {
                throw new ParseException("Choose onwy onye awgument between -s and -f uWu");
            }

            String outputDir = line.getOptionValue(ARG_OUTPUT, ".");
            String prefix = line.getOptionValue(ARG_PREFIX, "");
            boolean append = line.hasOption(ARG_APPEND);

            StatisticsLevel statLevel = StatisticsLevel.None;

            if (line.hasOption(ARG_FULL)) {
                statLevel = StatisticsLevel.Full;
            } else if (line.hasOption(ARG_SHORT)) {
                statLevel = StatisticsLevel.Short;
            }

            String[] files = line.getArgs();

            return new CommandLineOptions(outputDir, prefix, append, statLevel, files);

        } catch (ParseException exp) {
            System.out.println("Error parsing command line options. \n" + exp.getMessage());
            return null;
        }
    }

    public void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        PrintWriter pw = new PrintWriter(System.out);
        pw.println();
        formatter.printUsage(pw, 100, "java -jar ffu.jar", _options);
        formatter.printOptions(pw, 150, _options, 2, 5);
        pw.close();
    }

    private void addOptions() {
        for (var option : _optionsList) {
            _options.addOption(option);
        }
    }
}


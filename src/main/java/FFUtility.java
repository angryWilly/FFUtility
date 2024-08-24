import org.utility.FileProcesser;
import org.utility.options.OptionParser;

public class FFUtility {
    public FFUtility(String[] args) {
        var parser = new OptionParser(args);
        var utils = parser.parseOptions();

        if (utils == null) {
            parser.printHelp();
            System.exit(-1);
        }

        var processer = new FileProcesser(utils);
        processer
                .processFiles(utils.getFiles())
                .createFiles()
                .printStatistics(utils.getStatisticsLevel());
    }
}
import org.utility.FileProcesser;
import org.utility.options.OptionParser;

public class FFUtility {
    public FFUtility(String[] args) {
        var parser = new OptionParser(args);
        var options = parser.parseOptions();

        if (options == null) {
            parser.printHelp();
            System.exit(-1);
        }

        var processer = new FileProcesser(options);
        processer
                .processFiles(options.getFiles())
                .createFiles()
                .printStatistics(options.getStatisticsLevel());
    }
}
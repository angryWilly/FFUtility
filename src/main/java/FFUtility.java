import org.utility.FileProcessor;
import org.utility.options.OptionParser;

public class FFUtility {
    public FFUtility(String[] args) {
        var parser = new OptionParser(args);
        var utils = parser.parseOptions();

        if (utils == null) {
            parser.printHelp();
            System.exit(-1);
        }

        FileProcessor processor = new FileProcessor(utils);
        processor
                .processFiles(utils.getFiles())
                .createFiles()
                .printStatistics();
    }
}
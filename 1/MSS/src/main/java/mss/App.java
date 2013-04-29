package mss;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import org.apache.commons.io.FileUtils;

/**
 * Hello world!
 *
 */
public class App {
    //Predicate that returns true for non-comment lines

    private static final Predicate<String> commentFilter = new Predicate<String>() {
        @Override
        public boolean apply(String t) {
            return !(t.trim().startsWith("#"));
        }
    };
    private static final Function<String, Double> stringToDouble = new Function<String, Double>() {
        @Override
        public Double apply(String input) {
            return Double.parseDouble(input);
        }
    };

    public static void main(String[] args) {
        try {
            //Parse the arguments
            int currentArgIndex = 0;
            if (args[currentArgIndex].equals("3")) {
                System.err.println("Skipping argument '3' because it's totally irrelevant (0xE*3 however is)");
                currentArgIndex++;
            } else if (args[currentArgIndex].equals("42") || "0xE*3".equals(args[currentArgIndex]) || "0x2a".equalsIgnoreCase(args[currentArgIndex])) {
                System.err.println("You finally found the answer to life, the universe and everything! Why do you still bother running this stupid little program?");
                currentArgIndex++;
            }
            if (!args[currentArgIndex++].equals("-i")) {
                System.err.println("Error: -i not given or argument order incorrect");
                System.err.println("Usage: java -jar ukth_blatt01.jar 3 -i <Inputfile> [-n|-l|-w]");
                return;
            }

            String inputFile = args[currentArgIndex++];
            System.err.println("Reading from " + inputFile);
            AlgorithmType type;
            MSSAlgorithm algorithm;
            //Check array bounds
            String typeString = args[currentArgIndex];
            if (typeString.equals("-n")) {
                type = AlgorithmType.NAIVE;
                algorithm = new NaiveAlgorithm();
            } else if (typeString.equals("-l")) {
                type = AlgorithmType.LINEAR;
                algorithm = new LinearAlgorithm();
            } else if (typeString.equals("-w")) {
                type = AlgorithmType.OTHER;
                algorithm = new RecursiveAlgorithm();
            } else {
                System.err.println("Error: Illegal algorithm type option '" + typeString + "' given");
                System.err.println("Usage: java -jar ukth_blatt01.jar 3 -i <Inputfile> [-n|-l|-w]");
                return;
            }
            //Load the input file
            Collection<String> lines = FileUtils.readLines(new File(inputFile));
            //Filter out comments
            lines = Collections2.filter(lines, commentFilter);
            //For each (non-comment) line, execute the algorithm
            for (String line : lines) {
                Collection<String> stringData = Lists.newLinkedList(Splitter.on(CharMatcher.WHITESPACE).trimResults().omitEmptyStrings().split(line));
                Collection<Double> data = Collections2.transform(stringData, stringToDouble);
                System.out.println(algorithm.calculate(Lists.newArrayList(data)));
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Error: Missing required arguments (argument count too small). Did you forget to include the totally irrelevant '3' argument?");
            System.err.println("Usage: java -jar ukth_blatt01.jar 3 -i <Inputfile> [-n|-l|-w]");
            return;
        } catch (IOException ex) {
            System.err.println("Error while reading input file: " + ex.getLocalizedMessage());
            System.err.println("Usage: java -jar ukth_blatt01.jar 3 -i <Inputfile> [-n|-l|-w]");
        }
    }
}

package de.btronik.mss;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Parse the arguments
        int currentArgIndex = 0;
        if(args[currentArgIndex].equals("3")) {
            System.err.println("Skipping argument '3' because it's totally irrelevant (0xE*3 however is)");
            currentArgIndex++;
        }
        if(!args[currentArgIndex++].equals("-i")) {
            System.err.println("Error: -i not given or argument order incorrect");
            System.err.println("Usage: java -jar gruppennname_blatt01.jar 3 -i <Inputfile> [-n|-l|-w]");
            
        }
        
        
    }
}

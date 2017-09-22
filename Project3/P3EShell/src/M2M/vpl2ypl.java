package M2M;

import MDELite.Marquee2Arguments;
import MDELite.Utils;
import PrologDB.DB;
import PrologDB.DBSchema;
import PrologDB.Table;
import PrologDB.Tuple;


public class vpl2ypl {

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        
        // Step 1: standard marquee processing
        Marquee2Arguments mark = new Marquee2Arguments(vpl2ypl.class, ".vpl.pl", ".ypl.pl", args);
        String inputFileName = mark.getInputFileName();
        String outputFileName = mark.getOutputFileName();
        String appName = mark.getAppName(inputFileName);
        
        // Step 2: read in database
        // TODO
        
        // Step 3: read ypl schema, create empty database and get empty tables
        // TODO
        
        // Step 4: translate vBoxes to yumlBox
        // TODO
        
        // Step 5: translate vAssociations to yumlAssociations
        // TODO
        
        // Step 6: output database
        // TODO
    }
    
    /**
     * method that translates an "arrow" attribute in vpl
     * to a corresponding "arrow" in ypl
     * @param direction -- int arrow1 or arrow2
     * @param t -- tuple
     * @return String translation of vpl "arrow" to ypl "end'
     * throws exception if direction is not 1 or 2
     */
    public static String xlateArrow(int direction, Tuple t) {
        // TODO
        return null;
    }
    
    /**
     * translate vpl lineStyle attribute to ypl lineType
     */
    public static String xlateLineType(Tuple t) {
        // TODO
        return null;
    }
    
    /**
     * yuml doesn't like '%' characters, replace '%' with ';' which 
     * yuml does understand as a "carriage return"
     * @param x -- String to translate
     * @return -- translated string
     */
    public static String nl(String x) {
        return x.replace("%",";");
    }
    
}

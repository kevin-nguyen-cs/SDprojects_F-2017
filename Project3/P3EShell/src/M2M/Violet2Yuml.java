package M2M;

import MDELite.Marquee2Arguments;
import Violett.ClassParser;
import Yuml.ClassUnParser;
import VPL.Conform;

public class Violet2Yuml {
    
    public static void main(String... args) {
        // Step 1: standard marquee processing
        Marquee2Arguments mark = new Marquee2Arguments(Violet2Yuml.class, ".class.violet", ".yuml.yuml", args);
        String inputFileName = mark.getInputFileName();
        String outputFileName = mark.getOutputFileName();
        String appName = mark.getAppName(inputFileName);
        
        // Step 2: perform transformation chain
        
        //parse *.class.violet file into *.vpl.pl   
        ClassParser.main(appName + ".class.violet " + appName + ".vpl.pl");
         
        //check that *.vpl.pl meets schema constraints
        Conform.main(appName + ".vpl.pl");
        
        //translate *.vpl.pl to *.ypl.pl
        vpl2ypl.main(appName + ".vpl.pl");
        
        //unprase *.ypl.pl to yuml spec
        ClassUnParser.main(appName + ".ypl.pl");
    }
    
}

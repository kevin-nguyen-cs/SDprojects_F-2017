package M2M;

import MDELite.Marquee2Arguments;

public class Violet2Yuml {
    
    public static void main(String... args) {
        // Step 1: standard marquee processing
        Marquee2Arguments mark = new Marquee2Arguments(Violet2Yuml.class, ".class.violet", ".yuml.yuml", args);
        String inputFileName = mark.getInputFileName();
        String outputFileName = mark.getOutputFileName();
        String appName = mark.getAppName(inputFileName);
        
        // Step 2: perform transformation chain
        // TODO
    }
    
}

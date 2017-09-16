package VPL;

import org.junit.Test;

public class ConformTest {
    static final String testdata = "test/VPL/TestData/";
    static final String correct  = "test/VPL/Correct/";
    
    public ConformTest() {
    }
    
    public void doit(String file) {
        RegTest.Utility.redirectStdOut("out.txt");
        RegTest.Utility.redirectStdErr("err.txt");
        try {
        Conform.main(testdata+file+".vpl.pl");
        }
        catch (Exception e) {
        }
        RegTest.Utility.validate("out.txt",correct+file+".txt",false);
    }

    @Test
    public void CarRental() {
        doit("CarRental");
    }
    
    @Test
    public void Comp() {
        doit("Comp");
    }
    
    @Test
    public void DecayProduct() {
        doit("DecayProduct");
    }
    
    @Test
    public void diagram1() {
        doit("diagram1");
    }
    
    @Test
    public void squirrel() {
        doit("squirrel");
    }
 
    @Test
    public void straight() {
        doit("straight");
    }
    
    @Test
    public void PrettyBad() {
        doit("prettyBad");
    }
    
    @Test
    public void bogus() {
        doit("bogus");
    }
}

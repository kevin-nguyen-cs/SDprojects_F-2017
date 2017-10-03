package toyuml;


import org.junit.Test;
import static org.junit.Assert.*;

public class ToYumlTest {
    static String Data = "test/Data/";
    static String Output = "test/Output/";
    
    public ToYumlTest() {
    }
    
    // take file X.prog1.pl and convert it into a X.yuml.yuml file
    // output is placed in a separate directory
    // these are not really regression tests, but rather a script to
    // automate the conversion of several prog1.pl files.
    
    public void doit(String testFile) {
        ToYuml.main(Data+testFile+".prog1.pl", Output + testFile+".yuml.yuml");
        assert(true);
    }
    
    @Test
    public void cyp() {
        doit("MDELite.classYumlParser");
    }

    @Test
    public void PS() {
        doit("PrologScannar");
    }
    
    @Test
    public void PT() {
        doit("PrologTokens");
    }
    
    @Test
    public void RT() {
        doit("RegTest");
    }
    
    @Test
    public void bexpr() {
        doit("bexpr");
    }
    
    @Test
    public void graphics() {
        doit("graphics");
    }
    
    @Test
    public void tree() {
        doit("Tree");
    }
    
    @Test
    public void pong() {
        doit("pong");
    }
    
}

package M2M;

import static org.junit.Assert.fail;
import org.junit.Test;

public class Violet2YumlTest {

    static final String correct = "test/M2M/Correct/";
    static final String violet = ".class.violet";
    static final String yuml = ".yuml.yuml";

    public Violet2YumlTest() {
    }

    public void doit(String filename) {
        try {
        RegTest.Utility.redirectStdOut("out2.txt");
        M2M.Violet2Yuml.main(correct + filename + violet, "out.txt");
        RegTest.Utility.validate("out.txt", correct + filename + yuml, false);
        } catch (Exception e ) {
            RegTest.Utility.validate("out2.txt", correct+filename+".txt", false);
        }
    }

    @Test
    public void straight() {
        doit("straight");
    }

    @Test
    public void c5() {
        doit("c5");
    }

    @Test
    public void int3() {
        doit("int3");
    }
//
    @Test
    public void noLinks() {
        doit("noLinks");
    }

    @Test
    public void test1() {
        doit("test1");
    }

    @Test
    public void violet() {
        doit("violet");
    }

    @Test
    public void wlinks() {
        doit("wLinks");
    }
}

package M2M;

import org.junit.Test;
import static org.junit.Assert.*;

public class vpl2yplTest {

    static final String correct = "test/M2M/Correct/";
    static final String violet = ".vpl.pl";
    static final String yuml = ".ypl.pl";

    public vpl2yplTest() {
    }

    public void doit(String filename) {
        try {
            M2M.vpl2ypl.main(correct + filename + violet, "out.txt");
            RegTest.Utility.validate("out.txt", correct + filename + yuml, false);
            return;
        } catch (Exception e) {
            System.out.println(e);
            fail();
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

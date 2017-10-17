package logicGates;

import Pins.*;
import GatesApp.*;
import java.util.LinkedList;
import static GatesApp.Feature.*;

public class Not extends Gate implements Printable {
    InputPin i1;
    OutputPin o;

    public Not(String name) {
        super(name);
        i1 = new InputPin("i1", this);
        inputs.put("i1",i1);
        o = new OutputPin("o",this);
        outputs.put("o", o);
        if (tables) {
            table.add(this);
        }
    }
    
    @Feature(tables) 
    
    static LinkedList<Not> table;
    
    public static void resetTable() {
        table = new LinkedList<>();
    }
    
    public static LinkedList<Not> getTable() { 
        return table;
    }
    
    public void printTableHeader() {
        System.out.println("table(not,[name,\"input\",\"output\"]).");
    }
    
    public void print() {
        System.out.printf("not(%s,'%s','%s').\n", name, i1, o);
    }
    
    @Feature(eval)   /* for logic diagram evaluation */
    
    public Value getValue() {
        // TO DO
        return Value.UNKNOWN;
    }
    
}

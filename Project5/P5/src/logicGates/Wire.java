package logicGates;

import Pins.*;
import GatesApp.*;
import java.util.LinkedList;
import static GatesApp.Feature.*;

public class Wire implements Printable {
    public InputPin i;
    public OutputPin o;
    
    public Wire( OutputPin o, InputPin i ) {
        i = i;
        o = o;
        o.addWire(this);
        i.addWire(this);
    }
    
    public Wire( InputPort o, Gate i, String name) {
        this(o.getOutput(), i.getInput(name));
    }
    
    public Wire( Gate from, String frompin, Gate to, String topin ) {
        this(from.getOutput(frompin),to.getInput(topin));
    }
    
    public Wire( Gate from, Gate to ,String topin ) {
        this(from, "o", to, topin);
    }
    
    public Wire( Gate from, OutputPort port) {
        this(from.getOutput("o"),port.getInput());
    }
    
    
    @Feature(tables)
    
    static LinkedList<Wire> table;
    
    public static void resetTable() {
        // TO DO
    }
    
    public static LinkedList<Wire> getTable() { 
        // TO DO
        return null;
    }
    
    public void printTableHeader() {
        System.out.println("table(wire,[\"from\",\"to\"]).");
    }
    
    public void print() {
        // TO DO
    }
    
    @Feature(constraints)
    
    public boolean isUsed() {
        // TO DO
        return false;
    }
    
    public static boolean verify() {
        // TO DO
        return false;
    }
    
    @Feature(eval)
    
    public Value getValue() {
        // TO DO
        return Value.UNKNOWN;
    }
}

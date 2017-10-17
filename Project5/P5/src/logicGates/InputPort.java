package logicGates;

import Errors.NoValueSet;
import Pins.*;
import GatesApp.*;
import java.util.*;
import static GatesApp.Feature.*;

public class InputPort extends Gate implements Printable {
    OutputPin o;

    public InputPort(String name) {
        super(name);
        o = new OutputPin("o", this);
        outputs.put("o", o);
        
        if (tables) {
            table.add(this);
        }
    }
    
    public OutputPin getOutput() {
        return outputs.get("o");
    }
    
    @Feature(tables) 
    
    static LinkedList<InputPort> table;
    
    public static void resetTable() {
        table = new LinkedList<>();
    }
    
    public static LinkedList<InputPort> getTable() { 
        return table;
    }
    
    public void printTableHeader() {
        System.out.println("table(inputPort,[name,\"outputPin\"]).");
    }
    
    public void print() {
        System.out.printf("inputPort(%s,'%s').\n", name, o);
    }
    
    @Feature(eval)   /* for evaluation */
            
    Value value = Value.UNKNOWN;
        
    public void setValue(Value v) {
        // TO DO
    }
    
    public Value getValue() {
        // TO DO
        return null;
    }
}

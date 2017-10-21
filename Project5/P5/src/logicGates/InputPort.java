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
        
        if (tables)
            table.add(this);
    }
    
    public OutputPin getOutput() {
        return outputs.get("o");
    }
    
    @Feature(tables) 
    
    static LinkedList<InputPort> table;
    
    public static void resetTable() {
        // TO DO
        table = new LinkedList<>(); //intialize brand new linkedlist
    }
    
    public static LinkedList<InputPort> getTable() { 
        // TO DO
        return table; //return this table, which is linkedlist data structure
    }
    
    public void printTableHeader() {
        System.out.println("table(inputPort,[name,\"outputPin\"]).");
    }
    
    public void print() {
        // TO DO
        System.out.printf("inputPort(%s,'%s').\n", name, o); //print based on inputPort stucture
    }
    
    @Feature(eval)   /* for evaluation */
            
    Value value = Value.UNKNOWN;
    
    /* sets the values to the start of the circuit */
    public void setValue(Value v) { 
        // TO DO
        value = v; //calling from main...so set this field value. If not set then return unknown
    }
    
    /* retrives value of inputPort to the circuit */
    public Value getValue() {
        // TO DO
        return value; //just reutrn the value
    }
}
package logicGates;

import Pins.*;
import GatesApp.*;
import java.util.*;
import static GatesApp.Feature.*;

public class OutputPort extends Gate implements Printable {
    InputPin i1;

    public OutputPort(String name) {
        super(name);
        i1 = new InputPin("i1", this);
        inputs.put("i1", i1);
        
        if (tables)
            table.add(this);
    }
    
    public InputPin getInput() { 
        return inputs.get("i1");
    }
    
    @Feature(tables) 
    
    static LinkedList<OutputPort> table;
    
    public static void resetTable() {
        // TO DO
        table = new LinkedList<>(); //intialize brand new linkedlist
    }
    
    public static LinkedList<OutputPort> getTable() { 
        // TO DO
        return table; //return this table, which is linkedlist data structure
    }
    
    public void printTableHeader() {
        System.out.println("table(outputPort,[name,\"inputPin\"]).");
    }
    
    public void print() {
        // TO DO
        System.out.printf("outputPort(%s,'%s').\n", name, i1); //print based on outputPort stucture
    }
    
    @Feature(eval)
    
    public Value getValue() {
        // TO DO
        return Value.UNKNOWN;
    }
}

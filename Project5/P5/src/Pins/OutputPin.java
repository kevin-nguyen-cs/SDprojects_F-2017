package Pins;

import java.util.*;
import logicGates.*;
import GatesApp.*;
import logicGates.Wire;

public class OutputPin {
    Value value;
    public String name;
    Gate outputOf;
    //AbstractList<Wire> wiresFrom;
    LinkedList<Wire> wiresFrom;
    
    public OutputPin(String name, Gate parent) {
        wiresFrom = new LinkedList<Wire>();
        //AbstractList<Wire> wiresFrom = new LinkedList<Wire>();
        this.name = name;
        outputOf = parent;
    }
    
    public void addWire(Wire w) {
        wiresFrom.add(w);
    }
    
    public String toString() {
        return outputOf.name+ "->" + name;
    }
    
    public String nameOfGate() {
        return outputOf.name;
    }
    
    @Feature(Feature.constraints)
    
    public boolean isUsed() {
        if (wiresFrom.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    @Feature(Feature.eval)
    
    public Value getValue() {
        // TO DO
        return null;
    }
}

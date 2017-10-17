package Pins;

import java.util.*;
import logicGates.*;
import GatesApp.*;
import logicGates.Wire;

public class OutputPin {
    Value value;
    public String name;
    Gate outputOf;
    AbstractList<Wire> wiresFrom;
    //LinkedList<Wire> wires = new LinkedList<Wire>();
    
    public OutputPin(String name, Gate parent) {
        name = name;
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
        // TO DO
        return false;
    }
    
    @Feature(Feature.eval)
    
    public Value getValue() {
        // TO DO
        return null;
    }
}

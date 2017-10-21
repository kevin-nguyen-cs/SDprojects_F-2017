package Pins;

import GatesApp.*;
import logicGates.Gate;
import Errors.*;
import logicGates.Wire;


public class InputPin {

    public String name;
    Gate inputOf;
    Wire wireFrom; // only from one source
    
    public InputPin(String name, Gate parent) {
        this.name = name;
        inputOf = parent;
    }
    
    public void addWire(Wire w) {
        //check condition if this wire is already set, because only one wire can connect
        //to an input pin
        wireFrom = w;
    }
    
    public String toString() {
        return name + "->" +inputOf.name ;
    }
    
    @Feature(Feature.constraints)
    
    public boolean isUsed() {
        if (wireFrom == null) {
            return false;
        } 
        return true;
    }
    
    public String nameOfGate() {
        return inputOf.name;
    }
    
    @Feature(Feature.eval)    /*  this is for circuit execution */
    
    public Value getValue() {
        Wire thisWire = wireFrom.getValue(); //get incoming value from wire to this pin? [Gate1->OutputPin -- wire -- InputPin-->Gate2]
        if (thisWire == Value.TRUE) {
            return Value.TRUE;
        }
        return Value.FALSE;
    }
}

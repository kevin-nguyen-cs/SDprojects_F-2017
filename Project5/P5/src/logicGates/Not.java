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
        // TO DO
        table = new LinkedList<>(); //intialize brand new linkedlist
    }
    
    public static LinkedList<Not> getTable() { 
        // TO DO
        return table; //return this table, which is linkedlist data structure
    }
    
    public void printTableHeader() {
        System.out.println("table(not,[name,\"input\",\"output\"]).");
    }
    
    public void print() {
        // TO DO
        System.out.printf("not(%s,'%s','%s').\n", name, i1, o); //print based on NOT gate stucture
    }
    
    @Feature(eval)   /* for logic diagram evaluation */
    
    public Value getValue() {
        Value v1 = i1.getValue();
        if (v1==Value.TRUE)
            return Value.FALSE;
        else
            return Value.TRUE;
    }
}
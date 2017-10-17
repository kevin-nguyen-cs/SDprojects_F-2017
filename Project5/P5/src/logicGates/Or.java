package logicGates;

import Pins.*;
import GatesApp.*;
import java.util.LinkedList;
import static GatesApp.Feature.*;

public class Or extends Gate implements Printable {
    InputPin i1, i2;
    OutputPin o;

    public Or(String name) {
        super(name);
        i1 = new InputPin("i1",this);
        i2 = new InputPin("i2", this);
        inputs.put("i1",i1);
        inputs.put("i2",i2);
        o = new OutputPin("o",this);
        outputs.put("o", o);
        if (tables) {
            table.add(this);
        }
    }
    
    @Feature(tables) 
    
    static LinkedList<Or> table;
    
    public static void resetTable() {
        table = new LinkedList<>(); //new list
    }
    
    public static LinkedList<Or> getTable() { 
        return table; //return linkedlist table
    }
    
    public void printTableHeader() {
        System.out.println("table(or,[name,\"input1\",\"input2\",\"output\"]).");
    }
    
    public void print() {
        System.out.printf("or(%s,'%s','%s','%s').\n", name, i1, i2, o); //print based on OR gate structure
    }
    
    @Feature(eval)
            
    public Value getValue() { 
        Value v1 = i1.getValue();
        Value v2 = i2.getValue();
        if (v1==Value.TRUE || v2==Value.TRUE)
            return Value.TRUE;
        else
            return Value.FALSE;
    }
}

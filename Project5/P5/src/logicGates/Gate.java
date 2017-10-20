package logicGates;

import Pins.*;
import Errors.*;
import GatesApp.*;
import java.util.*;
import static GatesApp.Feature.*;


public abstract class Gate {

    public String name;
    HashMap<String, InputPin> inputs;
    HashMap<String, OutputPin> outputs;

    public Gate(String name) {
        this.name = name;
        inputs = new HashMap<String, InputPin>();
        outputs = new HashMap<String, OutputPin>();
    }

    public InputPin getInput(String name) {
        return inputs.get(name);
    }

    public OutputPin getOutput(String name) {
        return outputs.get(name);
    }

    @Feature(tables)

    public static void resetDB() {
        // TO DO
        And.resetTable();
        Or.resetTable();
        Not.resetTable();
        Wire.resetTable();
        InputPort.resetTable();
        OutputPort.resetTable();   
    }

    public static void printDB() {
        // TO DO
        printTable(And.getTable());
        printTable(Or.getTable());
        printTable(Not.getTable());
        printTable(Wire.getTable());
        printTable(InputPort.getTable());
        printTable(OutputPort.getTable());
    }

    public static <G extends Printable> void printTable(LinkedList<G> t) {
        System.out.println();
        if (t.isEmpty())
            return;
        t.getFirst().printTableHeader();
        for (G g : t) {
            g.print();
        }
    }

    @Feature(constraints)

    /* Check if all names are unique in the table, if not then return false else true */
    public static boolean hasUniqueNames(LinkedList<? extends Gate> table) {
        /* local declarations */
        ArrayList<String> listOfNames = new ArrayList<String>();
        Boolean isUnique = true;
        /* go through each gate object */
        for(Gate g : table) {
            /* check if name is already inside table */
            if(listOfNames.contains(g.name)) {
                isUnique = false;
                break;
            }
            listOfNames.add(g.name); //add to list;
        }
        return isUnique;
    }

    /* all pins must be used, connected to wire; if not then return false else true */
    public static boolean allInputsUsed() { 
        
        boolean andUsed = true;
        for (Gate g : And.getTable()) {
            InputPin i1 = g.getInput("i1");
            InputPin i2 = g.getInput("i2");
            
            andUsed = (i1.isUsed() && i2.isUsed());
            
            if(andUsed == false)
                return false;
        }
        
        boolean orUsed = true;
        for (Gate g : Or.getTable()) {
            InputPin i1 = g.getInput("i1");
            InputPin i2 = g.getInput("i2");
            
            orUsed = (i1.isUsed() && i2.isUsed());
            
            if(orUsed == false)
                return false;
        }
        
        boolean notUsed = true;
        for (Gate g : Not.getTable()) {
            InputPin i1 = g.getInput("i1");
            
            notUsed = (i1.isUsed());
            
            if(notUsed == false)
                return false;
        }
        
        return (andUsed && orUsed && notUsed);
    }

    /* all pins must be used, connected to wire; if not then return false else true */
    public static boolean allOutputsUsed() {
        
        boolean andUsed = true;
        for (Gate g : And.getTable()) {
            OutputPin o1 = g.getOutput("o");
            
            andUsed = (o1.isUsed());
            
            if (andUsed == false)
                return false;
        }
        
        boolean orUsed = true;
        for (Gate g : Or.getTable()) {
            OutputPin o1 = g.getOutput("o");
            
            orUsed = (o1.isUsed());
            
            if (orUsed == false)
                return false;
        }
        
        boolean notUsed = true;
        for (Gate g : Not.getTable()) {
            OutputPin o1 = g.getOutput("o");
            
            notUsed = (o1.isUsed());
            
            if (notUsed == false)
                return false;
        }
        
        return (andUsed && orUsed && notUsed);
    }

    /* extra constraints that are considered */
    public boolean extra() {  // subclasses override this method if something special needs to be done
        // TO DO
        return true;
    }

//    public static <G extends Gate> boolean verify(String label, LinkedList<Gate> table) {
//	// TO DO
//	// evaluate the following constraints
//	// 1. every gate of type G has a unique name
//        if (!hasUniqueNames(table)) {
//            return false;
//        }
//	// 2. every gate of type G has all of its inputs used (see above)
//        if(!allInputsUsed()) {
//            return false;
//        }
//	// 3. every gate of type G has all of its outputs used (see above)
//        if(!allOutputsUsed()) {
//            return false;
//        }
//	// 4. any constraint you might think that is particular to
//	//    gates of type G, evaluate it see extra() above
//        return true;
//    }

    public static boolean verify() {
        
        /* Evaluate hasUniqueNames constraint for each subclass of gate.
           Wires are not included as wires do not have names.
        */
        boolean andResult = hasUniqueNames(And.getTable());
        boolean notResult = hasUniqueNames(Not.getTable());
        boolean orResult = hasUniqueNames(Or.getTable());
        boolean inportResult = hasUniqueNames(InputPort.getTable());
        boolean outportResult = hasUniqueNames(OutputPort.getTable());
        
        boolean hasUniqueNames = (andResult && notResult && orResult && inportResult && outportResult);
        //System.out.println("hasUniqueNames: " + hasUniqueNames);
        
        /* All Inputs Used Constraint
        
        */
        boolean allInputsUsed = allInputsUsed();
        //System.out.println("allInputsUsed: " + allInputsUsed);

        /* All OutPuts Used Constraint */
        
        boolean allOutputsUsed = allOutputsUsed();
        //System.out.println("allOutputsUsed: " + allOutputsUsed);
        
        
        
        return hasUniqueNames && allInputsUsed && allOutputsUsed;
    }

    @Feature(eval)

    public abstract Value getValue();  // evaluate gate(inputs)
}

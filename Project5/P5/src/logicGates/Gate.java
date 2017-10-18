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
        name = name;
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
        InputPort.resetTable();
        OutputPort.resetTable();
        Wire.resetTable();
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
    public boolean hasUniqueNames(String label, LinkedList<G> table) {
        /* local declarations */
        ArrayList<String> listOfNames = new ArrayList<String>();
        Boolean isUnique = true;
        /* go through each gate object */
        for(G g : table) {
            /* check if name is already inside table */
            if(!listOfNames.contains(g.name)) {
                isUnique = false;
                break;
            }
            listOfNames.add(g.name); //add to list;
        }
        return isUnique;
    }

    /* all pins must be used, connected to wire; if not then return false else true */
    public boolean allInputsUsed(String label, LinkedList<G> table) { //edited with parameters**
        /* local declaration */
        Boolean used = true;
        /* go through each gate object */
        for(G g : table) {
            //NOTE: GATE CAN HAVE MULTIPLE INPUTS? ITERATE THROUGH THEM? VERIFY EACH?
            // InputPin myInput = g.getInput(label); //get input pin for this gate
            // if (!myInput.isUsed()) { //call isUsed function in InputPin class
            //     used = false;
            //     break;
            // }
        }
        return used;
    }

    /* all pins must be used, connected to wire; if not then return false else true */
    public boolean allOutputsUsed(String label, LinkedList<G> table) { //edited with parameters**
        /* local declaration */
        Boolean used = true;
        /* go through each gate object */
        for(G g : table) {
            //NOTE: GATE CAN HAVE MULTIPLE INPUTS? ITERATE THROUGH THEM? VERIFY EACH?
            // InputPin myOutput = g.getOutput(label); //get input pin for this gate
            // if (!myOutput.isUsed()) { //call isUsed function in OutputPin class
            //     used = false;
            //     break;
            // }
        }
        return used;
    }

    /* extra constraints that are considered */
    public boolean extra() {  // subclasses override this method if something special needs to be done
        // TO DO
        return true;
    }

    public static <G extends Gate> boolean verify(String label, LinkedList<G> table) {
	// TO DO
	// evaluate the following constraints
	// 1. every gate of type G has a unique name
        if (!hasUniqueNames(label, table)) {
            return false;
        }
	// 2. every gate of type G has all of its inputs used (see above)
        if(!allInputsUsed(label, table)) {
            return false;
        }
	// 3. every gate of type G has all of its outputs used (see above)
        if(!allOutputsUsed(label table)) {
            return false;
        }
	// 4. any constraint you might think that is particular to
	//    gates of type G, evaluate it see extra() above
        return true;
    }

    public static boolean verify() {
        // TO DO
        return false;
    }

    @Feature(eval)

    public abstract Value getValue();  // evaluate gate(inputs)
}

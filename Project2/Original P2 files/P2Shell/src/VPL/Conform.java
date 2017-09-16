package VPL;

import MDELite.Marquee4Conform;
import PrologDB.Constraints;
import PrologDB.DB;
import PrologDB.ErrorReport;
import PrologDB.Table;

public class Conform {
    
    static DB db;
    static Table vBox;
    static Table vAssociation;
    static ErrorReport er;
    
    /**
     * @param args -- single path to vpl database which is to be tested for
     * conformance
     */
    public static void main(String... args) {
        // Step 1: Standard marquee processing
        Marquee4Conform mark = new Marquee4Conform(Conform.class, ".vpl.pl", args);
        String inputFileName = mark.getInputFileName();

        // Step 2: read database and create error handler
        db = DB.readDataBase(inputFileName);
        vBox = db.getTableEH("vBox");
        vAssociation = db.getTableEH("vAssociation");
        er = new ErrorReport();

        // Step 3: now evaluate each rule and collect errors in er (ErrorReport)
        // You may implement these constraints in any order, not necessarily the
        // order in which they are listed below.  Virtually all constraints can
        // be evaluated using one of the standard constraints listed in
        // class PrologDB.Constraints.  Familiarize yourself with these methods
        // you will save yourself lots of time.
        
        // Also -- look at Correct answers in regression tests -- you'll see how
        // to phrase errors to match correct output.
        
        // Middle Labels Constraint -- no middle labels on associations is permitted 
        vAssociation.stream()
                .filter(c-> !(c.is("middleLabel","")))  //Filter any tuples with non-blank middle lables.
                .forEach(c->er.add("vAssociation(" + c.get("id") + "...) has middle label should be empty")); //Add error message.
        
          
        // All vBox Identifiers are unique
        Constraints.isUnique(vBox, "id", er);   
        
        // All vAssociation identifiers are unique
        Constraints.isUnique(vAssociation, "id", er);
        
        // No illegal references: each cid1 and cid2 field must reference a legal vBox identifier    
        //Ensure that each entry in column "cid1" aligns with a legal vbox id.
        Constraints.isLegit(vAssociation, "cid1", vBox, "id", er);
        //Ensure that each entry in column "cid2" aligns with a legal vbox id.
        Constraints.isLegit(vAssociation, "cid2", vBox, "id", er);

        // Unique Name Constraint -- classes and interfaces must have unique names, 
        // no class can share the same name of an interface, and vice versa.
        Constraints.isUnique(vBox, "name", er);

        // Null Names Constraint -- classes and interfaces cannot have null names.
        vBox.stream()
                .filter(c-> (c.is("name", ""))) //Null names are represented by empty strings in the name column.
                .forEach(c->er.add("vBox(" + c.get("id")+ "...) has null name"));

        // Triangle Constraint -- inheritance is a line with one arrow ending in a TRIANGLE. Its other arrow must be NONE.
        //these constraints can be checked using constraints.java implies method - if (predicate1), then (predicate2) must be true, else error.
        
        // No Labels in Inheritance Constraint -- inheritance cannot have role labels at either end.
        // TODO
        
        // class-class Constraint -- class-class relationships must be SOLID.
        // TODO
        
        // interface-interface Constraint -- int-int relationships must be SOLID
        // TODO
        
        // Implements Constraint1 -- class implements relationships must be DOTTED
        // TODO
       
        // All interfaces have no fields -- the field attribute is empty ("")
        // TODO
        
        // All notes should have no methods and no fields -- the field and method attributes are empty ("")
        // TODO
        
        // Step 5: report errors (if any) and exit
        er.printReport(System.out);
    }
}

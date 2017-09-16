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
        
        // Middle Labels Constraint -- no middle labels on associations is permitted.
        // TODO
        
        // All vBox Identifiers are unique
        // TODO
        
        // All vAssociation identifiers are unique
        // TODO
        
        // No illegal references: each cid1 and cid2 field must reference a legal vBox identifier
        // TODO

        // Unique Name Constraint -- classes and interfaces must have unique names, 
        // no class can share the same name of an interface, and vice versa.
        // TODO

        // Null Names Constraint -- classes and interfaces cannot have null names.
        // TODO

        // Triangle Constraint -- inheritance is a line with one arrow ending in a TRIANGLE. Its other arrow must be NONE.
        // TODO
        
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

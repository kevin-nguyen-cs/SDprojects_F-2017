/*

nathaniel fousek - ndf333 - nathaniel.fousek@gmail.com
Kevin Nguyen - kdn433 - kxnguyen60@utexas.edu
*/


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
        //in a vAssociation, if arrow1 = TRIANGLE, arrow2 = "", and vice versa.
        Constraints.implies(vAssociation,
                (c-> c.is("arrow1","TRIANGLE")),                //"if" predicate
                (c-> c.is("arrow2","")),                        //then this must be true.
                "inheritance paired with non-null arrow", er);  //else report an error.
        
        Constraints.implies(vAssociation,
                (c-> c.is("arrow2","TRIANGLE")), 
                (c-> c.is("arrow1","")), 
                "inheritance paired with non-null arrow", er);
        
        // No Labels in Inheritance Constraint -- inheritance cannot have role labels at either end.
        //in a vAssociation, if arrow1 or arrow2 = triangle, role1 and role 2 must both be "".
        Constraints.implies(vAssociation,
                (c-> c.is("arrow1","TRIANGLE")),                
                ((c-> c.is("role1","") && c.is("role2", ""))),                    
                "inheritance with roles", er);
        Constraints.implies(vAssociation,
                (c-> c.is("arrow2","TRIANGLE")),                
                ((c-> c.is("role1","") && c.is("role2", ""))),                    
                "inheritance with roles", er); 
        
        // class-class Constraint -- class-class relationships must be SOLID.
        //in a vAssociation, if type1 = c, and type2 = c, lineType must be "" (solid)
        Constraints.implies(vAssociation,
                (c-> c.is("type1","c") && c.is("type2", "c")),                
                (c-> c.is("lineStyle","")),                    
                "class-class relationships that are dotted", er); 
        
        // interface-interface Constraint -- int-int relationships must be SOLID
        //in a vAssociation, if type1 = i, and type2 = i, lineType must be "" (solid)
        Constraints.implies(vAssociation,
                (c-> c.is("type1","i") && c.is("type2", "i")),                
                (c-> c.is("lineStyle","")),                    
                "interface-interface relationships that are dotted", er); 
        
        // Implements Constraint1 -- class implements relationships must be DOTTED
        // relation between type1 = c and type2 = i must be dotted?
        Constraints.implies(vAssociation,
                (c->c.is("type1", "i") && c.is("type2", "c")),
                (c->c.is("lineStyle", "DOTTED")),
                "interface-class relationships that are solid", er);
                
        Constraints.implies(vAssociation,
                (c->c.is("type1", "c") && c.is("type2", "i")),
                (c->c.is("lineStyle", "DOTTED")),
                "interface-class relationships that are solid", er);   
        
        //Extends constraint - Inheritance relationships must be SOLID
        Constraints.implies(vAssociation,
                (c->c.is("arrow1", "TRIANGLE") || c.is("arrow2", "TRIANGLE") && c.is("type1", "i") || c.is("type2" , "i")),
                (c->c.is("lineStyle", "")),
                "has extends relationships that are DOTTED", er);
       
        // All interfaces have no fields -- the field attribute is empty ("")
        Constraints.implies(vBox,
                (c-> c.is("type","i")),                
                (c-> c.is("fields","")),                    
                "interface with non-empty fields", er); 
        
        // All notes should have no methods and no fields -- the field and method attributes are empty ("")
        Constraints.implies(vBox,
                (c-> c.is("type","n")),                
                (c-> c.is("fields","") && c.is("methods", "")),                    
                "note with non-empty fields and methods", er); 
        
        // Step 5: report errors (if any) and exit
        er.printReport(System.out);
    }
}


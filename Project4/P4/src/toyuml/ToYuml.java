package toyuml;

import MDELite.Marquee2Arguments;
import MDELite.RunningBear;
import static MDELite.RunningBear.RBSetup;
import PrologDB.Table;
import PrologDB.Tuple;
import Violett.ClassUnParser;


public class ToYuml extends RunningBear {
    
    static Table bcClass;
    static Table bcMember;
    
    static String blank = " ";
    static String end = ";";

    // standard MDELite Tool call...
    public static void main(String... args) {
        
        // Step 1: standard marquee processing
        Marquee2Arguments mark = new Marquee2Arguments(ClassUnParser.class, ".prog1.pl", ".yuml.yuml", args);
        RBSetup(mark, args);
        
        // Step 2: read tables
        bcClass = db.getTableEH("bcClass");
        bcMember = db.getTableEH("bcMember");
        
        // Step 3: produce list of class definitions with their attributes and methods
        for (Tuple c : bcClass.tuples()) {
            String name = c.get("name");
            String cid = c.get("cid");
            String fieldsNmethods = "";
            
            for (Tuple m : bcMember.tuples()) {
                if (m.get("cid").equals(cid)) {   
                    String thisMember = "";
                    if (m.get("static").equals("true")) {
                        //if this is a static member, we preface it with "_" character
                        thisMember += "_";
                    }
                    thisMember += m.get("type");
                    thisMember += " ";
                    thisMember += m.get("sig");
                    
                    /* We only add this if we cannot represent this as an association instead.
                       This member can be represented as an association if the following things hold true:
                            1. isTypeAClassOfPackage returns true
                            2. type is not the class we are currently considering
                            3. this member does not represent a method (does not contain "(" character)
                    */
                    if (isTypeAClassOfPackage(m.get("type"))) {
                        if (m.get("type").equals(name)) {
                            fieldsNmethods += thisMember + ";";
                        } else {
                            if (thisMember.contains("(")) 
                                fieldsNmethods += thisMember + ";";    
                        }
                    } else {
                        fieldsNmethods += thisMember + ";";
                    }           
                    fieldsNmethods = replaceBadChars(fieldsNmethods);        
                }
            }
            //output this to yuml spec
            l("[%s|%s|]", name, fieldsNmethods);
        }
        
        // Step 4: produce inheritance links among package classes
        for (Tuple c : bcClass.tuples()) {
            //inheritance is drawn between a class and its superclass, if superclass has a box
            //[class]-^[superclass]
            String name = replaceBadChars(c.get("name"));
            String superName = replaceBadChars(c.get("superName"));
            
            if (isTypeAClassOfPackage(superName)) {
                l("[%s]-^[%s]", name, superName);
            }
        }
        
        // Step 5: produce associations among package clases
        for (Tuple c : bcClass.tuples()) {
            // to do
        }
    }
    
    // given the string name of a class, does this class belong to the
    // analyzed package?  Yes or no?
    static boolean isTypeAClassOfPackage(String typeName) {
        String type = returnClassName(typeName);
        boolean result = bcClass.stream().anyMatch((c) -> (c.is("name", type)));
        return result;
    }
    
    // Yuml doesn't like "[]" or ","  Replace these characters
    // with ones that it does like
    static String replaceBadChars(String x) {
        return x.replace("[]", "#").replace(",", " ");
    }
    
    
    // A type name could be Object[][] -- a name with optional
    // brackets.  Return just the name of this class without brackets.
    static String returnClassName(String typeName) {
        String tn = typeName.replace("[]", "");
        return tn;
    }
    
}

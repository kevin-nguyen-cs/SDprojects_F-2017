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
            // to do
        }
        
        // Step 4: produce inheritance links among package classes
        for (Tuple c : bcClass.tuples()) {
            // to do
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

package M2M;

import MDELite.Marquee2Arguments;
import MDELite.Utils;
import PrologDB.DB;
import PrologDB.DBSchema;
import PrologDB.Table;
import PrologDB.Tuple;


public class vpl2ypl {
    
    static DB inputdb;
    static Table vBox;
    static Table vAssociation;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        
        // Step 1: standard marquee processing
        Marquee2Arguments mark = new Marquee2Arguments(vpl2ypl.class, ".vpl.pl", ".ypl.pl", args);
        String inputFileName = mark.getInputFileName();
        String outputFileName = mark.getOutputFileName();
        String appName = mark.getAppName(inputFileName);
        
        // Step 2: read in database
        //System.out.println("sanity check 2: " + inputFileName);
        inputdb = DB.readDataBase(inputFileName);
        //System.out.println("sanity check 3: i am not the error");
        vBox = inputdb.getTableEH("vBox");
        vAssociation = inputdb.getTableEH("vAssociation");

        // Step 3: read ypl schema, create empty database and get empty tables
        DBSchema dbs = DBSchema.readSchema("ypl.schema.pl");
        DB outputdb = new DB("ypl", dbs);
        
        Table yumlBox = outputdb.getTable("yumlBox");
        Table yumlAssociation = outputdb.getTable("yumlAssociation");
        
        // Step 4: translate vBoxes to yumlBox
        String id, type, name, methods, fields;
        
        // get tuple instances per vBox tuples
       for (Tuple thisTuple : vBox.tuples()) {
           id = nl(thisTuple.get("id"));

           type = nl(thisTuple.get("type"));

           name = nl(thisTuple.get("name"));

           methods = nl(thisTuple.get("methods"));

           fields = nl(thisTuple.get("fields"));

           yumlBox.addTuple(id, type, name, fields, methods);
       }       
        
        // Step 5: translate vAssociations to yumlAssociations
        String aID, box1, role1, end1, lineType, box2, role2, end2;
        for (Tuple thisTuple : vAssociation.tuples()) {
            aID = nl(thisTuple.get("id"));
            
            //yumlAssociation box1 and box2 columns correspond to vAssociation cid1 and cid2 columns
            box1 = nl(thisTuple.get("cid1"));
            box2 = nl(thisTuple.get("cid2"));
            
            //yumlAssociation role1 and role2 columns correspond to vAssociation role1 and role2 columns
            role1 = nl(thisTuple.get("role1"));
            role2 = nl(thisTuple.get("role2"));
            
            //we must translate arrow1 and arrow2 columns of vAssociation tuple to valid yumlAssociation end columns
            end1 = xlateArrow(1, thisTuple);
            end2 = xlateArrow(2, thisTuple);
            
            //must translate vAssociation lineStyle to yumlAssociation lineType
            lineType = xlateLineType(thisTuple);
            
            yumlAssociation.addTuple(aID, box1, role1, end1, lineType, box2, role2, end2);
        }
        
        // Step 6: output database
        outputdb.print(outputFileName);
    }
    
    /**
     * method that translates an "arrow" attribute in vpl
     * to a corresponding "arrow" in ypl
     * @param direction -- int arrow1 or arrow2
     * @param t -- tuple
     * @return String translation of vpl "arrow" to ypl "end'
     * throws exception if direction is not 1 or 2
     */
    public static String xlateArrow(int direction, Tuple t) {
        /* local delcaration */
        String result = "";
        /* try and catch statement to translate given direction */
        try {
            /* check if arrow is outside bounds, if so raise exception */
            if (direction > 2 || direction < 1) {
                throw new java.lang.RuntimeException();
            }
            result = ""; //TRANSLATION BEGINS HERE
        }
        catch (Exception e) {
            System.err.println("ERROR: Arrow is illegally defined!") //error report
        }
        return null;
    }
    
    /**
     * translate vpl lineStyle attribute to ypl lineType
     */
    public static String xlateLineType(Tuple t) {
        // TODO
        return null;
    }
    
    /**
     * yuml doesn't like '%' characters, replace '%' with ';' which 
     * yuml does understand as a "carriage return"
     * @param x -- String to translate
     * @return -- translated string
     */
    public static String nl(String x) {
        return x.replace("%",";");
    }   
}

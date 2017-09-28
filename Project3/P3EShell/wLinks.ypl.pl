dbase(ypl,[yumlBox,yumlAssociation]).

table(yumlBox,[id,type,"name","fields","methods"]).
yumlBox(ClassNode0,c,'aclass','','').
yumlBox(ClassNode1,c,'bclass','','').
yumlBox(ClassNode2,c,'cclass','','').
yumlBox(ClassNode3,c,'dclass','','').
yumlBox(InterfaceNode0,i,'aint','','').
yumlBox(InterfaceNode1,i,'bint','','').

table(yumlAssociation,[id,box1,"role1","end1","lineType",box2,"role2","end2"]).
yumlAssociation(A0,ClassNode0,'b,c','','-',ClassNode1,'a','>').
yumlAssociation(A1,ClassNode3,'','','-',ClassNode1,'','^').
yumlAssociation(A2,InterfaceNode0,'','','-',InterfaceNode1,'','^').
yumlAssociation(A3,ClassNode3,'','','-.-',InterfaceNode0,'','^').
yumlAssociation(A4,ClassNode2,'x','<>','-',ClassNode3,'y','').
yumlAssociation(A5,ClassNode0,'','++','-',ClassNode2,'z','').


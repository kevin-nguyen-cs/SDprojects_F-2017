dbase(ypl,[yumlBox,yumlAssociation]).

table(yumlBox,[id,type,"name","fields","methods"]).
yumlBox(InterfaceNode0,i,'don','','m1();m2(int);m3(int float)').

table(yumlAssociation,[id,box1,"role1","end1","lineType",box2,"role2","end2"]).


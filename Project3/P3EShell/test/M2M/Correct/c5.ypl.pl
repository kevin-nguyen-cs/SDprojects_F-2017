dbase(ypl,[yumlBox,yumlAssociation]).

table(yumlBox,[id,type,"name","fields","methods"]).
yumlBox(ClassNode0,c,'Don','','int m1(float int);string m2(int X)').

table(yumlAssociation,[id,box1,"role1","end1","lineType",box2,"role2","end2"]).


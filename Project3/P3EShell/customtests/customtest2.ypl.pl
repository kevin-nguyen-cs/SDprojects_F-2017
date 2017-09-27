dbase(ypl,[yumlBox,yumlAssociation]).

table(yumlBox,[id,type,"name","fields","methods"]).
yumlBox(ClassNode0,c,'c','','').
yumlBox(ClassNode1,c,'d','','').

table(yumlAssociation,[id,box1,"role1","end1","lineType",box2,"role2","end2"]).
yumlAssociation(A0,ClassNode0,'','','-',ClassNode1,'fieldB','++').


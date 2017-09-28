dbase(ypl,[yumlBox,yumlAssociation]).

table(yumlBox,[id,type,"name","fields","methods"]).
yumlBox(ClassNode0,c,'class0','','').
yumlBox(ClassNode1,c,'class1','a','m()').
yumlBox(ClassNode2,c,'class2','a;b','m1(a);m2(b)').
yumlBox(InterfaceNode0,i,'int0','','').
yumlBox(InterfaceNode1,i,'int1','','m()').
yumlBox(InterfaceNode2,i,'int2','','m();n()').
yumlBox(ClassNode3,c,'class3','a;"b";c;','m1(a);m2(b);m(3)').
yumlBox(InterfaceNode3,i,'int3','','m();n();z()').
yumlBox(NoteNode0,n,'one','','').
yumlBox(NoteNode1,n,'two','','').
yumlBox(Void0,n,'','','').

table(yumlAssociation,[id,box1,"role1","end1","lineType",box2,"role2","end2"]).


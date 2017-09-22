dbase(ypl,[yumlBox,yumlAssociation]).

table(yumlBox,[id,type,"name","fields","methods"]).
yumlBox(ClassNode0,c,'violetClass','"name";"fields";"methods";x;y','').
yumlBox(ClassNode1,c,'violetInterface','"name";"methods";x;y','').
yumlBox(ClassNode2,c,'violetAssociation','"role1";arrow1;"type1";"role2";arrow2;"type2";"lineStyle"','').
yumlBox(ClassNode3,c,'violetInterfaceExtends','','').
yumlBox(ClassNode4,c,'violetClassImplements',';','').
yumlBox(ClassNode5,c,'violetMiddleLabels','"label"','').
yumlBox(ClassNode6,c,'endPoint','','').

table(yumlAssociation,[id,box1,"role1","end1","lineType",box2,"role2","end2"]).
yumlAssociation(A0,ClassNode1,'idb,idx','','-',ClassNode3,'','').
yumlAssociation(A1,ClassNode0,'cid','','-',ClassNode4,'','').
yumlAssociation(A2,ClassNode1,'iid','','-',ClassNode4,'','').
yumlAssociation(A3,ClassNode0,'','','-',ClassNode6,'','^').
yumlAssociation(A4,ClassNode1,'','','-',ClassNode6,'','^').
yumlAssociation(A5,ClassNode6,'cid1,cid2','','-',ClassNode2,'','').
yumlAssociation(A6,ClassNode5,'','','-',ClassNode6,'cid1,cid2','').


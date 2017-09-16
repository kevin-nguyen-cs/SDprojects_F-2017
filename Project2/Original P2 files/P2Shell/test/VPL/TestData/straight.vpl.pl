dbase(vpl,[vBox,vAssociation]).

table(vBox,[id,type,"name","fields","methods",x,y]).
vBox(ClassNode0,c,'Long','','a%b%d%c%d%e%f',727.0,236.0).
vBox(ClassNode1,c,'Short','','',1190.0,250.0).

table(vAssociation,[id,cid1,type1,"role1","arrow1",cid2,type2,"role2","arrow2","bentStyle","lineStyle","middleLabel"]).
vAssociation(A0,ClassNode0,c,'','',ClassNode1,c,'','TRIANGLE','','','').
vAssociation(A1,ClassNode0,c,'','DIAMOND',ClassNode1,c,'','','HVH','','').


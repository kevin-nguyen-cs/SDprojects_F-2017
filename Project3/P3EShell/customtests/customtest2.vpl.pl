dbase(vpl,[vBox,vAssociation]).

table(vBox,[id,type,"name","fields","methods",x,y]).
vBox(ClassNode0,c,'c','','',0.0,0.0).
vBox(ClassNode1,c,'d','','',3.0,1.0).

table(vAssociation,[id,cid1,type1,"role1","arrow1",cid2,type2,"role2","arrow2","bentStyle","lineStyle","middleLabel"]).
vAssociation(A0,ClassNode0,c,'','',ClassNode1,c,'fieldB','BLACK_DIAMOND','HVH','','').


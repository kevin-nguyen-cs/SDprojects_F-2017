dbase(vpl,[vBox,vAssociation]).

table(vBox,[id,type,"name","fields","methods",x,y]).
vBox(ClassNode0,c,'ClassA','','',465.0,171.0).
vBox(ClassNode1,c,'ClassB','','',764.0,169.0).

table(vAssociation,[id,cid1,type1,"role1","arrow1",cid2,type2,"role2","arrow2","bentStyle","lineStyle","middleLabel"]).
vAssociation(A0,ClassNode0,c,'abc','BLACK_DIAMOND',ClassNode1,c,'def','TRIANGLE','VHV','DOTTED','').


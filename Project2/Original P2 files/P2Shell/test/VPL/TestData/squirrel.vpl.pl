dbase(vpl,[vBox,vAssociation]).

table(vBox,[id,type,"name","fields","methods",x,y]).
vBox(ClassNode0,c,'A','','',791.0,115.0).
vBox(ClassNode1,c,'B','','',592.0,278.0).
vBox(ClassNode2,c,'C','','',750.0,397.0).
vBox(ClassNode3,c,'D','','',983.0,281.0).
vBox(ClassNode4,c,'E','','',973.0,396.0).

table(vAssociation,[id,cid1,type1,"role1","arrow1",cid2,type2,"role2","arrow2","bentStyle","lineStyle","middleLabel"]).
vAssociation(A0,ClassNode0,c,'','TRIANGLE',ClassNode1,c,'','','VHV','','').
vAssociation(A1,ClassNode1,c,'','TRIANGLE',ClassNode2,c,'','','VHV','','').
vAssociation(A2,ClassNode0,c,'','',ClassNode2,c,'','TRIANGLE','','','').
vAssociation(A3,ClassNode1,c,'','',ClassNode1,c,'','TRIANGLE','VHV','','').
vAssociation(A4,ClassNode3,c,'','V',ClassNode1,c,'','V','HVH','','').
vAssociation(A5,ClassNode2,c,'0..1','DIAMOND',ClassNode4,c,'','BLACK_DIAMOND','','DOTTED','').
vAssociation(A6,ClassNode4,c,'','',ClassNode4,c,'','DIAMOND','','','').


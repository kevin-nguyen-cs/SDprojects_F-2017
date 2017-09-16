dbase(vpl,[vBox,vAssociation]).

table(vBox,[id,type,"name","fields","methods",x,y]).
vBox(ClassNode0,c,'Figure','position','draw()',322.0,234.0).
vBox(ClassNode1,c,'Group','','draw()',237.0,392.0).
vBox(ClassNode2,c,'Polygon','','draw()',405.0,387.0).

table(vAssociation,[id,cid1,type1,"role1","arrow1",cid2,type2,"role2","arrow2","bentStyle","lineStyle","middleLabel"]).
vAssociation(A0,ClassNode1,c,'partOf','DIAMOND',ClassNode0,c,'consistsOf','V','','','').
vAssociation(A1,ClassNode2,c,'','',ClassNode0,c,'','TRIANGLE','VHV','','').
vAssociation(A2,ClassNode1,c,'','',ClassNode0,c,'','TRIANGLE','VHV','','').


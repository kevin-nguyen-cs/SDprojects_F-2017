dbase(vpl,[vBox,vAssociation]).

table(vBox,[id,type,"name","fields","methods",x,y]).
vBox(ClassNode0,c,'customer','','',433.0,168.0).
vBox(ClassNode1,c,'receipt','','',824.0,168.0).
vBox(ClassNode2,c,'contract','','',825.0,369.0).
vBox(ClassNode3,c,'CarRentalCompany','','',420.0,363.0).
vBox(ClassNode4,c,'RentalCar','','',425.0,509.0).
vBox(InterfaceNode0,i,'Don','','',830.0,519.0).
vBox(InterfaceNode1,i,'Don','','',262.0,260.0).

table(vAssociation,[id,cid1,type1,"role1","arrow1",cid2,type2,"role2","arrow2","bentStyle","lineStyle","middleLabel"]).
vAssociation(A0,ClassNode0,c,'1','BLACK_DIAMOND',ClassNode2,c,'*','','','','').
vAssociation(A1,ClassNode0,c,'1','BLACK_DIAMOND',ClassNode1,c,'paid','','HVH','','').
vAssociation(A2,ClassNode2,c,'1','BLACK_DIAMOND',ClassNode1,c,'1','DIAMOND','HVH','','').
vAssociation(A3,ClassNode2,c,'1','',ClassNode4,c,'1','BLACK_DIAMOND','','','').
vAssociation(A4,ClassNode3,c,'1 belongs_to','',ClassNode4,c,'* owns','V','','','').
vAssociation(A5,ClassNode3,c,'*','BLACK_DIAMOND',ClassNode0,c,'*','BLACK_DIAMOND','','','').


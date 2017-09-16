dbase(vpl,[vBox,vAssociation]).

table(vBox,[id,type,"name","fields","methods",x,y]).
vBox(ClassNode0,c,'DecayText','','toString%',863.0,252.0).
vBox(ClassNode1,c,'DecayProduct','','getName()%getType()%getTextName()',623.0,48.0).
vBox(ClassNode2,c,'ParticleType','','getAntiName()%getantiTexName()%GetData()%getDecayChannel()%getPDGID()',645.0,249.0).
vBox(ClassNode3,c,'Family','','getFamily()%getParticle()',428.0,249.0).
vBox(ClassNode4,c,'Yappi','','getFamily%getParticle()',303.0,424.0).
vBox(ClassNode5,c,'XMLYappi','','',296.0,590.0).
vBox(ClassNode6,c,'Data','','getName()%getConfidenceLevel()%getNegError()%getPosError()%getScaleFactor()%getUnit()%',647.0,522.0).
vBox(ClassNode7,c,'DecayGroup','','getName',880.0,538.0).
vBox(ClassNode8,c,'DecayChannel','','getConfidenceLevel()%getDecayGroup()%getDecayParticles()%getFraction()%getName()',1049.0,402.0).

table(vAssociation,[id,cid1,type1,"role1","arrow1",cid2,type2,"role2","arrow2","bentStyle","lineStyle","middleLabel"]).
vAssociation(A0,ClassNode3,c,'','',ClassNode1,c,'','TRIANGLE','VHV','','').
vAssociation(A1,ClassNode2,c,'','',ClassNode1,c,'','TRIANGLE','VHV','','').
vAssociation(A2,ClassNode0,c,'','',ClassNode1,c,'','TRIANGLE','VHV','','').
vAssociation(A3,ClassNode5,c,'','',ClassNode4,c,'','TRIANGLE','VHV','','').
vAssociation(A4,ClassNode8,c,'n','',ClassNode1,c,'1','V','VH','','list').
vAssociation(A5,ClassNode3,c,'1','',ClassNode2,c,'n','V','VH','','map').
vAssociation(A6,ClassNode3,c,'1','',ClassNode3,c,'n','V','HVH','','').
vAssociation(A7,ClassNode4,c,'1','',ClassNode3,c,'n','V','VH','','map').
vAssociation(A8,ClassNode4,c,'1','',ClassNode2,c,'n','V','','','pdgidName').
vAssociation(A9,ClassNode2,c,'1','',ClassNode6,c,'n','V','HVH','','map').
vAssociation(A10,ClassNode2,c,'1','',ClassNode7,c,'n','V','HVH','','map').
vAssociation(A11,ClassNode8,c,'','DIAMOND',ClassNode7,c,'1','V','HVH','','').
vAssociation(A12,ClassNode2,c,'1','',ClassNode8,c,'n','V','','','').


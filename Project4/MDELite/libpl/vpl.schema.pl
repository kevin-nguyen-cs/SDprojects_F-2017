% Violet (vpl) class database

dbase(vpl,[vBox,vAssociation]).

% type = c(class),i(nterface),n(ote).  packages are skipped

table(vBox,[id,type,"name","fields","methods",x,y]).

% type1,type2 = c(lass) or i(nterface)
% lineStyle = ""(solid) or "DOTTED"
% arrow1,2 = V, TRIANGLE, DIAMOND, BLACK_DIAMOND
% bentStyle = "", HV, VH, HVH, VHV

table(vAssociation,[id,cid1,type1,"role1","arrow1",cid2,type2,"role2","arrow2","bentStyle","lineStyle","middleLabel"]).


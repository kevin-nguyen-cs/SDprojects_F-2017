% yuml class schema

dbase(ypl,[yumlBox,yumlAssociation]).

% type = n (for note), c (for class), i (for interface)

table(yumlBox,[id,type,"name","fields","methods"]).

% end1 = <> | ++ | ^ | < | "" (nothing)
% end2 = <> | ++ | ^ | > | "" (nothing)
% lineType = - | -.-

table(yumlAssociation,[id,box1,"role1","end1","lineType",box2,"role2","end2"]).

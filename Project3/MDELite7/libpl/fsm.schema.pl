% violet (fsm) state machine database

dbase(fsm,[node,edge]).

% ntype = state | note | init | final | point
% etype = arrow | note

table(node,[nid,ntype,"text","color",xpos,ypos]).
table(edge,[eid,etype,"label",startid,endid]).

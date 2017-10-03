dbase(prog1,[bcClass,bcMember]).

table(bcClass,[cid,"name","superName"]).
bcClass(c10,'tree.Node','Object').
bcClass(c11,'tree.NonTerminal','tree.Node').
bcClass(c12,'tree.Terminal','tree.Node').
bcClass(c13,'tree.Tree','Object').

table(bcMember,[mid,cid,static,"type","sig"]).
bcMember(m10,c10,true,'tree.Node','Node(String)').
bcMember(m11,c10,false,'String','name').
bcMember(m12,c10,false,'tree.Node','add(int,tree.Node)').
bcMember(m13,c10,false,'void','display()').
bcMember(m14,c11,true,'tree.NonTerminal','NonTerminal(String)').
bcMember(m15,c11,false,'tree.Node[]','children').
bcMember(m16,c11,false,'tree.Node','add(int,tree.Node)').
bcMember(m17,c11,false,'void','display()').
bcMember(m18,c12,true,'tree.Terminal','Terminal(String)').
bcMember(m19,c12,false,'tree.Node','add(int,tree.Node)').
bcMember(m20,c12,false,'void','display()').
bcMember(m21,c13,true,'tree.Tree','Tree()').
bcMember(m22,c13,true,'void','main(String[])').


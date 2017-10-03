dbase(prog1,[bcClass,bcMember]).

table(bcClass,[cid,"name","superName"]).
bcClass(c10,'graphics.Graphics','Object').
bcClass(c11,'graphics.Line','graphics.Graphics').
bcClass(c12,'graphics.Main','Object').
bcClass(c13,'graphics.Picture','graphics.Graphics').
bcClass(c14,'graphics.Rectangle','graphics.Graphics').
bcClass(c15,'graphics.Text','graphics.Graphics').

table(bcMember,[mid,cid,static,"type","sig"]).
bcMember(m10,c10,true,'graphics.Graphics','Graphics(String)').
bcMember(m11,c10,false,'void','indent(int)').
bcMember(m12,c10,false,'void','draw()').
bcMember(m13,c10,false,'void','draw(int)').
bcMember(m14,c11,true,'graphics.Line','Line()').
bcMember(m15,c11,false,'void','draw(int)').
bcMember(m16,c12,true,'graphics.Main','Main()').
bcMember(m17,c12,true,'void','main(String[])').
bcMember(m18,c12,true,'int','getCounter()').
bcMember(m19,c13,true,'graphics.Picture','Picture()').
bcMember(m20,c13,false,'graphics.Picture','add(graphics.Graphics)').
bcMember(m21,c13,false,'void','draw(int)').
bcMember(m22,c14,true,'graphics.Rectangle','Rectangle()').
bcMember(m23,c14,false,'void','draw(int)').
bcMember(m24,c15,true,'graphics.Text','Text()').
bcMember(m25,c15,false,'void','draw(int)').


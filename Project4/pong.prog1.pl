dbase(prog1,[bcClass,bcMember]).

table(bcClass,[cid,"name","superName"]).
bcClass(c10,'pong.A','Object').
bcClass(c11,'pong.B','Object').

table(bcMember,[mid,cid,static,"type","sig"]).
bcMember(m10,c10,true,'pong.A','A()').
bcMember(m11,c10,false,'pong.A','self').
bcMember(m12,c10,false,'pong.A[]','many').
bcMember(m13,c10,false,'pong.B','one').
bcMember(m14,c10,false,'pong.B[]','lots').
bcMember(m15,c11,true,'pong.B','B()').
bcMember(m16,c11,false,'pong.A','isSelf').
bcMember(m17,c11,false,'pong.A[]','isZMany').
bcMember(m18,c11,false,'pong.B','isOne').
bcMember(m19,c11,false,'pong.B[]','isLots').

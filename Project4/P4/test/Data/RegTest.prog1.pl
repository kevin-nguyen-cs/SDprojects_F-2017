dbase(prog1,[bcClass,bcMember]).
table(bcClass,[cid,"name","superName"]).
table(bcMember,[mid,cid,static,"type","sig"]).


bcClass(c36,'RegTest.Utility','Object').
bcMember(m247,c36,true,'int','autopsy').
bcMember(m248,c36,true,'void','init()').
bcMember(m249,c36,true,'void','validate(String,String,boolean,String[])').
bcMember(m250,c36,true,'void','validate(String,String,boolean)').
bcMember(m251,c36,true,'void','validate(String,boolean)').
bcMember(m252,c36,true,'void','validate(String,boolean,String[])').
bcMember(m253,c36,true,'void','redirectStdOut(String)').
bcMember(m254,c36,true,'void','redirectStdErr(String)').

% Schema for bootstrapping

dbase(meta,[domain,arrow,path]).

table(domain,[id,"name","ext","conformExecutable",temp]).
table(arrow,[id,"name","domainInputs","domainOutput","javaExecutable"]).
table(path,[id,"name","path"]).

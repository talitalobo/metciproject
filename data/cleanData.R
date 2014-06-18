# ingles americano, britanico, portugues, frances, italiano, espanhol

dados = read.table("database.txt", encoding="UTF-8", header=F)
write.table(database,"database.txt",row.names=F,col.names=F,sep="\t", quote=F)


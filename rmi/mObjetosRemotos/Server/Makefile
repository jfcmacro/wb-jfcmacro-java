.SUFFIXES: .class .java

.java.class:
	javac $< 

all: RecursoImpresora_Skel.class RecursoImpresora_Stub.class RecursoImpresora.class  ServidorRecursosImpl.class ServidorRecursosImpl_Stub.class ServidorRecursosImpl_Skel.class Servidor.class ServidorImpresoras.class

RecursoImpresora_Stub.class: RecursoImpresora.class
	rmic RecursoImpresora

RecursoImpresora_Skel.class: RecursoImpresora.class
	rmic  RecursoImpresoraImpl

ServidorRecursosImpl_Stub.class: ServidorRecursosImpl.class
	rmic ServidorRecursosImpl

ServidorRecursosImpl_Skel.class: ServidorRecursosImpl.class
	rmic ServidorRecursosImpl

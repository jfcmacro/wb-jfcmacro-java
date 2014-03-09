#!/bin/bash
sesion="Taller2"
sesionFile="$sesion".ltx
> $sesionFile
echo "\\documentclass[12pt]{article}" >> $sesionFile
echo "\\usepackage[spanish]{babel}" >> $sesionFile
echo "\\usepackage{url}" >> $sesionFile
echo "\\usepackage[latin1]{inputenc}" >> $sesionFile
echo "\\title{Taller 2 - Multicast}" >> $sesionFile
echo "\\author{Juan Francisco Cardona Mc'}" >> $sesionFile
echo "\\begin{document}" >> $sesionFile
echo "\\maketitle" >> $sesionFile
for i in `awk --field-separator="|" '{ print $1 }' archivos` 
do
#  nombre=`basename $i .cs`
  nombre=`grep $i archivos | awk --field-separator="|" '{ print $2 }'`
  echo "\\section*{$nombre}" >> $sesionFile
#  echo "\\begin{verbatim}" >> $sesionFile
#  cat  $i >> $sesionFile
#  echo "\\end{verbatim}" >> $sesionFile
  echo "\\begin{verbatim}" >> $sesionFile
  nl -w2 -ba -s": "  $i >> $sesionFile 
  echo "\\end{verbatim}" >> $sesionFile
  echo "\\url{http://dis.eafit.edu.co/cursos/st059/2003/1/032/Talleres/${sesion}/${i}}" >> $sesionFile
done
echo "\\end{document}" >> $sesionFile

cp $sesionFile ${HOME}/temp
mkdir ${HOME}/temp/$sesion
cp *.cs ${HOME}/temp/$sesion 
cd ${HOME}/temp
latex2html $sesionFile
cd $sesion
unix2dos *.cs
chmod 644 *.cs
cd ..
tar cvf /tmp/${sesion}.tar $sesion/


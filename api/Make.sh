cd src/api

mkdir -p ../api_jp
for i in *.java 
do
	grep -v '*EN' $i | sed 's/\*JP/\*/' | sed 's/api/api_jp/g' | tee ../api_jp/$i > /dev/null
done

mkdir -p ../api_en
for i in *.java
do
	grep -v '*JP' $i | sed 's/\*EN/\*/' | sed 's/api/api_en/g' | tee ../api_en/$i > /dev/null
done


cd ../..

JAVADOC=/cygdrive/c/Program\ Files/Java/jdk1.7.0_45/bin/javadoc
"$JAVADOC" -d htmp_jp -sourcepath src api_jp
"$JAVADOC" -d htmp_en -sourcepath src api_en

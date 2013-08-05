#!/bin/bash

VERSIONS=('3.6' '3.7' '3.8');

TIMESTAMP=`ls ../fr.obeo.releng.targetplatform-update/3.6/target/repository/plugins/fr.obeo.releng.targetplatform_* \
		| grep -v '_.*_.*' | cut -d'/' -f7 | cut -d'_' -f2 | sed -e 's/.jar//'`

for v in ${VERSIONS[@]}; do
	echo "Copying build" ${v}"-"${TIMESTAMP}
	mkdir -p ${v}/${TIMESTAMP}/
	cp -rf ../fr.obeo.releng.targetplatform-update/${v}/target/repository/* ${v}/${TIMESTAMP}/
	
	./comp-repo.sh ${v} \
		--name "Target Platform Definition DSL and Generator for Eclipse ${v}" \
		--eclipse '/Applications/eclipse 3.8.2' \
		add ${TIMESTAMP}/

	#thisFolder=`pwd`
	#./comp-repo.sh ${thisFolder} \
	#	--name "Target Platform Definition DSL and Generator" \
	#	--eclipse '/Applications/eclipse 3.8.2' \
	#	add ${v}/${TIMESTAMP}/
done

git add 2.*
git add composite*.jar
git commit -m "added build ${TIMESTAMP}"

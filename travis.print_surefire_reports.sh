#!/usr/bin/env sh

echo "Current directory is $(pwd)"
echo "\n=== SUREFIRE REPORTS ===\n"

for F in target/surefire-reports/*.txt
do
	if [ -f $F ]; then
	    echo $F
	    cat $F
	    echo
	fi
done

echo "\n=== TEST WORKSPACE LOGS ===\n"

for F in target/work/data/.metadata/*.log
do
    if [ -f $F ]; then
	    echo $F
	    cat $F
	    echo
	fi
done
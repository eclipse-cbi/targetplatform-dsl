#!/usr/bin/env sh

echo "Current directory is $(pwd)"
echo "\n=== SUREFIRE REPORTS ===\n"

for F in target/surefire-reports/*.txt
do
    echo $F
    cat $F
    echo
done

echo "\n=== TEST WORKSPACE LOGS ===\n"

for F in target/work/data/.metadata/*.log
do
    echo $F
    cat $F
    echo
done
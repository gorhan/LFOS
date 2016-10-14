#!/bin/sh

for clafer_file in *.cfr; do
	clafer $clafer_file
	IFS='.' read -ra clafer_file_prefix <<< "$clafer_file"
	java -jar ../tools/chocosolver.jar --file $clafer_file --output "./instances/$clafer_file_prefix.txt"
done

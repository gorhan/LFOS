#!/bin/sh

for clafer_file in *.cfr; do
	clafer $clafer_file
	IFS='.' read -ra clafer_file_prefix <<< "$clafer_file"
	echo "Alloy file has been created: $clafer_file_prefix"
	java -jar ../tools/alloy4.2.jar "${clafer_file_prefix}.als"
done

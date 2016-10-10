#!/bin/sh

for dot_in_file in *.dot; do
	IFS='.' read -ra dot_in_file_prefix <<< "$dot_in_file"
	dot -Tpdf -o "${dot_in_file_prefix}.pdf" $dot_in_file
	echo "PDF file is being created... OUTPUT: ${dot_in_file_prefix}.pdf"
done

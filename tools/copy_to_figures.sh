#!/bin/sh

to_path="$HOME/Dropbox/GPCE16/figures/"

for pdf_file in *.pdf; do
	cp $pdf_file $to_path
	echo "File ${pdf_file} is copied to ${to_path}${pdf_file}"
done

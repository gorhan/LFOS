#!/bin/sh

input="$1"
output="$2"

echo "PDF file is being created... OUTPUT: $(pwd $output)/$output"
dot -Tpdf -o $output $input
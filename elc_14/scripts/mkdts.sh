#!/bin/sh

echo "make dts from generated dtb"
echo "./mkdts.sh filename-without-ext"

DATE=`date +"%F-%H-%M"`

dtc -I dtb -O dts -o $@-ft.dts $@.dtb

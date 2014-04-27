#!/bin/sh

# make dtb
echo "make dtb"
echo "./mkdtb.sh filename-without-ext"

DATE=`date +"%F-%H-%M"`
OUTPUT_FILE=$@-$DATE-$USER

dtc -I dts -O dtb -o $OUTPUT_FILE.dtb $@.dts

# make flattend dts file for reference
dtc -I dtb -O dts -o $OUTPUT_FILE-ft.dts $OUTPUT_FILE.dtb

cp $OUTPUT_FILE.dtb $@.dtb
cp $OUTPUT_FILE-ft.dts $@-ft.dts

echo "DTB file is generated: $OUTPUT_FILE.dtb"
echo "scp $OUTPUT_FILE.dtb"
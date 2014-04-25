#!/bin/sh
#
# from: http://blog.harrylau.com/2009/08/generate-uboot-uimage.html
# 'make uImage' can do the same job
#
# convert vmlinuz to u-boot readable uImage
# usage>
#	./mkuimage.sh note	# note: comment to add to file name
#

DATE=`date +"%F-%H-%M"`
BLD_VER=`cat .version`
if [ "$#" -ne 1 ]; then
	NOTE=''
else
	NOTE="-$1"
fi

${CROSS_COMPILE}objcopy -O binary \
                                 -R .note -R .comment \
                                 -S vmlinux linux.bin

gzip -9 linux.bin
NAME=uImage.$DATE-$USER.u-boot-$BLD_VER$NOTE
VNAME=vmlinux.$DATE-$USER-$BLD_VER$NOTE
mkimage -A ppc -O linux -T kernel -C gzip \
                -a 0 -e 0 -n "Linux Kernel Image" \
                -d linux.bin.gz $NAME

rm -f linux.bin.gz
cp $NAME uImage.u-boot
cp .config config.$NAME
cp vmlinux $VNAME

echo scp $NAME

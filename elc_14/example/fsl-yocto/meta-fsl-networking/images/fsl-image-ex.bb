LICENSE = "EX-EULA"
EXTRA_IMAGE_FEATURES = "tools-debug debug-tweaks"
PR = "r21"

require images/fsl-image-core.bb

# custom
IMAGE_INSTALL += " \
	sample \
	scripts \
"

IMAGE_INSTALL += " \
	logrotate \
	cronie \
	ntp \
"
# from full
# tasks/task-fsl-full.bb
IMAGE_INSTALL += " \
    initscripts \
    modutils-initscripts \
    netbase \
    nfs-utils \
    nfs-utils-client \
    pkgconfig \
    time \
    udev \
    dhcp-client \
    strace \
    tcp-wrappers \
    openssl \
    libnfnetlink \
    net-tools \
"
inherit core-image

# erase block size 0x2000, 512MB nand
IMAGE_ROOTFS_SIZE = "8192"

IMAGE_FSTYPES = "tar.gz ext2.gz.u-boot jffs2"

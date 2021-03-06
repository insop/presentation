#
# bring mountmtd to init.d
#

DESCRIPTON = "mount opt"
LICENSE = ""
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"
PR = "r1"

INITSCRIPT_NAME = "mountmtd"
INITSCRIPT_PARAMS = "start 34 S ."

# the above init param sets up
# /etc/rcS.d# ls -ltr S34mountmtd 
# lrwxrwxrwx 1 root root 18 Feb 31  2000 S34mountmtd -> ../init.d/mountmtd


inherit autotools update-rc.d

SRC_URI = "file://mountmtd"

do_install () {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/mountmtd  ${D}${sysconfdir}/init.d/mountmtd
}

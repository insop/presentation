#
#

DESCRIPTION = "sc lib"
LICENSE = ""
PR = "r0"
PV = "1.0+git${SRCPV}"

LIC_FILES_CHKSUM = " "

SRC_URI = "git://git@example.git.git/sc.git;protocol=ssh"
SRCREV = "891d506e4881422312f28b07d698b3c80a7d0b"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CC="${CC}" LD="${LD}" AR="${AR}"'
export ARCH="${TARGET_ARCH}"
export CROSS_COMPILE="${TARGET_PREFIX}"
export BUILD="${STAGING_DIR_TARGET}/build"
export YOCTO_STAGING_DIR_TARGET="${STAGING_DIR_TARGET}"

do_configure() {
	echo "IN PROGRESS"
	./waf configure --prefix=${D}${prefix}
}

do_compile() {
	./waf build ${PARALLEL_MAKE}
}

do_install() {
	./waf install
	cp -aR ${S}/../build ${STAGING_DIR_TARGET}
}


PACKAGES = "${PN}"

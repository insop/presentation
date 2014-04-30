#
# Copyright (C) 2013 Gainspeed Inc.
#
# install wifi
#
# TODO: move this to meta-gainspeed
# Update the license
#

DESCRIPTON = "CLI"
LICENSE = ""
PR = "r1"
PV = "1.0+git${SRCPV}"

LIC_FILES_CHKSUM = " "

DEPENDS = "sc"

SRC_URI = "git://git@git.local.example.git/cli.git;protocol=ssh"
SRCREV = "7be23b74da467adcd5a5df15b49ba67e33de6"

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
	echo "IN BUILD"
	./waf build ${PARALLEL_MAKE}
}

do_install() {
	echo "IN install"
	./waf install

	install -d ${D}${bindir}
	install -d ${D}${sysconfdir}
	install -m 0755 ../build/cli/bin/cli  ${D}/${bindir}
}

FILES_${PN} += "/*"
FILES_${PN}-dbg += "/cli/.debug"

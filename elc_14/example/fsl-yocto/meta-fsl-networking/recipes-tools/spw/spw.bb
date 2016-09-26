#
# bring spw to init.d
#
#

DESCRIPTON = "spw build and install"
LICENSE = "example"
LIC_FILES_CHKSUM = "file://spw/RELDOCS/RELNOTES.html;md5=4c5e3eb0b2a476da65f21028014322"
PR = "r1"
PV = "1.0+git${SRCPV}"

INITSCRIPT_NAME = "startspw"
INITSCRIPT_PARAMS = "start 39 S ."

INHIBIT_PACKAGE_STRIP = "1"

inherit autotools update-rc.d

SRC_URI = "file://startspw\
		git://git.local.example.git/spw.git;protocol=ssh"
SRCREV = "cbc4473973bf34d4e338acd5630765230d23c"

DEPENDS="virtual/kernel"

S = "${WORKDIR}/git"

PARALLEL_MAKE = ""

do_compile_prepend () {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS MACHINE
}

do_compile() {
	oe_runmake -C 2_6 KERNDIR=${STAGING_KERNEL_DIR}
}

do_install_prepend () {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS MACHINE
}

do_install () {
	oe_runmake -C 2_6 DESTDIR=${D} install

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/startspw  ${D}${sysconfdir}/init.d/startspw
}

FILES_${PN} += "/*"
FILES_${PN}-dbg += "/spw/.debug /spw/lib/.debug"

INSANE_SKIP_${PN} = "debug-files dev-so arch"
INSANE_SKIP_${PN}-dbg = "debug-files dev-so arch"


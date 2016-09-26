#
# script install

SUMMARY = "scripts"
DESCRIPTION = "scripts"

LICENSE = ""
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=f40d7949109285ec7b81fdeb3b58"
PR = "r1"

SRC_URI = "file://*"

do_install () {
	install -d ${D}${bindir}
	install -d ${D}${sysconfdir}

	install -m 0755 ${WORKDIR}/app ${D}${bindir}
	install -m 0755 ${WORKDIR}/target ${D}${bindir}
	install -m 0755 ${WORKDIR}/clean ${D}${bindir}
	install -m 0755 ${WORKDIR}/reboot.sh ${D}${bindir}
	# overwrite syslog.conf with syslog.conf.template
	install -m 0644 ${WORKDIR}/syslog.conf.template ${D}${sysconfdir}/syslog.conf
	install -m 0644 ${WORKDIR}/syslog.conf.template ${D}${sysconfdir}

	# install version
	if [ -n "${SDK_VERSION}" ]; then
		echo "${SDK_VERSION}" > ${D}${sysconfdir}/sdk-version
	fi
}

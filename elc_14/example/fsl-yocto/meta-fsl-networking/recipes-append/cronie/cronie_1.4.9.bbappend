
PR_append = "+fsl_networking"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " file://daily "

do_install_append () {
	install -m 0644 ${WORKDIR}/daily  ${D}${sysconfdir}/cron.d/daily
}

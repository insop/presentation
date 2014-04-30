FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PRINC := "${@int(PRINC) + 2}"

SRC_URI += "file://logrotate-default.patch"


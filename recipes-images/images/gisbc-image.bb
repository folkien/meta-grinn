#Angstrom image to test systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"

DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'
#ROOTFS_PKGMANAGE_PKGS = ''

CONMANPKGS ?= "connman connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi connman-systemd"
CONMANPKGS_libc-uclibc = ""

IMAGE_INSTALL += " \
	angstrom-packagegroup-boot \
	chilisom-evb-packagegroup-basic \
	${CONMANPKGS} \
	${ROOTFS_PKGMANAGE_PKGS} \
        vsftpd \
        thttpd \
	python \
	python-dbus \
	libstdc++ \
	ntpdate \
	nano \
	packagegroup-sdk-target \
"

IMAGE_LINGUAS = "en-us pl-pl de-de"

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "shadow"

export IMAGE_BASENAME = "gisbc-image"

inherit image

SUMMARY = "This recipe builds and installs the UI for an rpi4-based liquid dispenser/measurer "
DESCRIPTION = "Recipe created by David Booth"
SECTION = "examples"
LICENSE = "CLOSED"

SRC_URI = "file://test-qt.cpp\
           file://test-qt.pro\
           "

DEPENDS += " qtbase wayland "

S = "${WORKDIR}"


do_install:append(){
        install -d ${D}${bindir}
        install -m 0775 test-qt ${D}${bindir}/
}

FILES:${PN} += "${bindir}/test-qt"

inherit  qmake5

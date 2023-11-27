SUMMARY = "This recipe builds and installs the UI for an rpi4-based liquid dispenser/measurer "
DESCRIPTION = "Recipe created by David Booth"
SECTION = "examples"
LICENSE = "CLOSED"

DEPENDS += "qtbase pigpio"
#REDPENDS_${PN} += "qtwayland"

SRC_URI = " \
        file://qt-dispense.pro \
        file://main.cpp \
        file://mainwindow.cpp \
        file://mainwindow.h \
        file://mainwindow.ui \
          "

S = "${WORKDIR}"

do_install:append() {
        install -d ${D}${bindir}
        install -m 0775 qt-dispense ${D}${bindir}/
}

FILES:${PN} += "${bindir}/myQTApp"

inherit qmake5

#EXTRA_OECMAKE = "-DOE_QMAKE_PATH_EXTERNAL_HOST_BINS='${OE_QMAKE_PATH_EXTERNAL_HOST_BINS}'"

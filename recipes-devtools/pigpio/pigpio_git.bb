# SUMMARY = "pigpio is a C library for the Raspberry which allows control of the General Purpose Input Outputs (GPIO)"
# DESCRIPTION = "pigpio is a C library for the Raspberry which allows control of the General Purpose Input Outputs (GPIO)"
# AUTHOR = "<komar@evologics.de>"

# SECTION = "utils"
# LICENSE = "CLOSED"

# COMPATIBLE_MACHINE = "^rpi$"


# SRCREV = "c33738a320a3e28824af7807edafda440952c05d"
# SRC_URI = "git://github.com/joan2937/pigpio.git;protocol=https;branch=master \
#           "

# S = "${WORKDIR}/git"

# # below code copied from: https://gist.github.com/dir-ableton/7ad9045e242165a9e4707c84e6df754b

# EXTRA_OEMAKE += "CC='${CC}'"
# EXTRA_OEMAKE += "CROSS_PREFIX=${TARGET_PREFIX}"
# # we don't need to strip, it will be stripped by build system
# EXTRA_OEMAKE += "STRIP=echo"
# EXTRA_OEMAKE += "PYINSTALLARGS='--root=$(DESTDIR) --prefix=${prefix}'"
# TARGET_CC_ARCH += "${LDFLAGS}"

# # gpio package will be empty with depends from all packages
# ALLOW_EMPTY:${PN} = "1"
# ALLOW_EMPTY:${PN}-dbg = "0"
# ALLOW_EMPTY:${PN}-dev = "0"

# FILES:${PN}-bin-pigs    = "${bindir}/pigs"
# FILES:${PN}-bin-pig2vcd = "${bindir}/pig2vcd"

# FILES:${PN}-bin-pigpiod    = "${bindir}/pigpiod"
# RDEPENDS:${PN}-bin-pigpiod = "lib${PN}"

# # *-bin package will be empty with depends from all *-bin-* packages
# RDEPENDS:${PN}-bin = " ${PN}-bin-pigpiod ${PN}-bin-pigs ${PN}-bin-pig2vcd"
# ALLOW_EMPTY:${PN}-bin = "1"

# FILES:lib${PN}  = "${libdir}/lib${PN}.so.*"
# FILES:lib${PN}  =+ "/opt/${PN}/cgi"

# FILES:lib${PN}_if  = "${libdir}/lib${PN}_if.so.*"
# FILES:lib${PN}_if2 = "${libdir}/lib${PN}_if2.so.*"

# #FILES_${PN}-dev = "${includedir}/*.h"
# FILES:${PN}-dev += "${libdir}/lib${PN}*.so"
# FILES:${PN}-doc = "${mandir}"

# # FILES:${PN}-python2 = "${libdir}/python2*/*"
# # FILES:${PN}-python3 = "${libdir}/python3*/*"

# PACKAGES =+ " ${PN}-bin-pigpiod ${PN}-bin-pigs ${PN}-bin-pig2vcd \
#               lib${PN} lib${PN}_if lib${PN}_if2"

# do_install() {
#     oe_runmake install DESTDIR=${D} prefix=${prefix} mandir=${mandir}
# }

# FILES:${PN} = "/usr/bin/* /usr/lib/* /usr/share/*"

# inherit lib_package





# look at code from: https://www.interelectronix.com/yocto-raspberry-pigpio-qt.html

DESCRIPTION = "pigpio"
SECTION = "devel/libs"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://UNLICENCE"

COMPATIBLE_MACHINE = "^rpi$"

SRCREV = "c33738a320a3e28824af7807edafda440952c05d"
SRC_URI = "git://github.com/joan2937/pigpio.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

FILES:${PN}-doc += "\
     /usr/man/man1/pigs.1 \
     /usr/man/man1/pig2vcd.1 \
     /usr/man/man1/pigpiod.1 \
     /usr/man/man3/pigpio.3 \
     /usr/man/man3/pigpiod_if.3 \
     /usr/man/man3/pigpiod_if2.3 \
"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

inherit pkgconfig cmake
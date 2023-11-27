SUMMARY = "This recipe builds and installs the UI for an rpi4-based liquid dispenser/measurer "
DESCRIPTION = "Recipe created by David Booth"
SECTION = "examples"
LICENSE = "CLOSED"

SRC_URI = "file://helloWorldCmake.cpp"

S = "${WORKDIR}"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile(){
        ${CXX} helloWorldCmake.cpp -o helloWorldCmake
}

do_install(){
        install -d ${D}${bindir}
        install -m 0775 helloWorldCmake ${D}${bindir}/
}

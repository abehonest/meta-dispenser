SUMMARY = "This recipe builds and installs a test for the pigpio library"
DESCRIPTION = "Recipe created by David Booth"
SECTION = "examples"
LICENSE = "CLOSED"

DEPENDS += " pigpio "

SRC_URI = "file://test-pigpio.cpp"

S = "${WORKDIR}"

TARGET_CC_ARCH += "${LDFLAGS}"


do_compile(){
        ${CXX} -Wall -pthread test-pigpio.cpp -o test-pigpio -lpigpio -lrt
}

do_install(){
        install -d ${D}${bindir}
        install -m 0775 test-pigpio ${D}${bindir}/
}

SUMMARY = "A very basic X11 image with a terminal"

IMAGE_FEATURES += "splash package-management x11-base"

LICENSE = "MIT"

COMPATIBLE_MACHINE = "^rpi$"

inherit core-image features_check

REQUIRED_DISTRO_FEATURES = "x11"

IMAGE_INSTALL:append = " packagegroup-rpi-dispenser qtbase qt-dispense test-pigpio "

QB_MEM = '${@bb.utils.contains("DISTRO_FEATURES", "opengl", "-m 512", "-m 256", d)}'

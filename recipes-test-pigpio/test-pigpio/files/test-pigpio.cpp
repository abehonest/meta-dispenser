#include <iostream>
#include <pigpio.h>
#include<unistd.h>

#define PHOTO_SENSOR 17
#define SPILL_SENSOR 27
#define MOTOR_DRIVE 22
#define LASER_DRIVE 4

int main(){
	std::cout << "Hello World!\n";

	if(gpioInitialise() < 0){
        std::cout << "PIGPIO Initialization failed\n";
        exit(1);
    }
    else{
        std::cout << "PIGPIO Initialization Successful :)\n";
    }

	gpioSetMode(PHOTO_SENSOR, PI_INPUT);
	gpioSetMode(SPILL_SENSOR, PI_INPUT);
	gpioSetMode(MOTOR_DRIVE, PI_OUTPUT);
	gpioSetMode(LASER_DRIVE, PI_OUTPUT);

	while(1){
		gpioWrite(LASER_DRIVE,0);
		sleep(1);
		gpioWrite(LASER_DRIVE,1);
		std::cout << "Photosensor: " << gpioRead(PHOTO_SENSOR) << "\n" << std::endl;
		sleep(1);
	}
    gpioTerminate();




	return 0;
}

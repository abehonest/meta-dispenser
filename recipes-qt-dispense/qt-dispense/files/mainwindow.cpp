#include "mainwindow.h"
#include "./ui_mainwindow.h"
#include <pigpio.h>
#include <unistd.h>

#define MOTOR_DRIVE 22
#define PHOTO_SENSOR 17
#define LASER_DRIVE 4



int snappedVal = 0;

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    ui->pushButton->setText("Dispense " + QString::number(ui->dial->value()) + "ml");

    gpioInitialise();
    gpioSetMode(PHOTO_SENSOR, PI_INPUT);
    gpioSetMode(MOTOR_DRIVE, PI_OUTPUT);
    gpioSetMode(LASER_DRIVE, PI_OUTPUT);

    gpioWrite(LASER_DRIVE, 1);
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_dial_valueChanged(int value)
{

//    snappedVal = value;
    if(value % 10 != 0){
        int smallMult = (value/10) * 10;
        int largeMult = smallMult + 10;

        snappedVal = ((largeMult - value) > (value - smallMult)) ? smallMult : largeMult;
    }


    ui->pushButton->setText("Dispense " + QString::number(snappedVal) + "ml");
//    ui->dial->setValue(snappedVal);

}


void MainWindow::on_pushButton_clicked()
{

    // if cup is present
    if(gpioRead(PHOTO_SENSOR) == 1){
        ui->pushButton->setText("Dispensing " + QString::number(snappedVal) + "ml...");
        gpioWrite(MOTOR_DRIVE, 1);
        sleep(snappedVal/10);
        gpioWrite(MOTOR_DRIVE, 0);
        ui->pushButton->setText("Dispense " + QString::number(snappedVal) + "ml");
    }

    else{
        ui->pushButton->setText("Please place cup!");
    }
    

}


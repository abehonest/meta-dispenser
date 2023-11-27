#include "mainwindow.h"
#include "./ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    ui->pushButton->setText("Dispense " + QString::number(ui->dial->value()) + "ml");
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_dial_valueChanged(int value)
{

    int snappedVal = value;
    if(value % 10 != 0){
        int smallMult = (value/10) * 10;
        int largeMult = smallMult + 10;

        snappedVal = ((largeMult - value) > (value - smallMult)) ? smallMult : largeMult;
    }


    ui->pushButton->setText("Dispense " + QString::number(snappedVal) + "ml");
//    ui->dial->setValue(snappedVal);

}


package frc.robot.utils;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class Logger
{

    public Logger()
    {

    }

    public static void printTelemetry()
    {
        Timer loggerTime = new Timer();
        loggerTime.start();
        if(loggerTime.get() == 10)
        {
            Robot.m_EvoShifter.printGearPos();
            Robot.m_drivetrain.printPower();
            loggerTime.reset();
        }
    }

}
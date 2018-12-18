package frc.robot.utils;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Robot;

public class ShifterToggler
{
    private static ShifterToggler toggler;

    private Solenoid out, in;
    private Boolean gearChanged = false;
    private shifterPos gearPos = shifterPos.HIGHGEAR;
    private shifterPos lastPos = gearPos;
    private Timer timer;


    public ShifterToggler()
    {
        this.out = new Solenoid(3);
        this.in  = new Solenoid(4);
        this.timer = new Timer();
    }

    public void toggleGear()
    {
        //timer.reset();
        //timer.start();
        //System.out.println("Timer Started");
        if(gearPos == shifterPos.HIGHGEAR)
        {
            Robot.m_EvoShifter.shiftDown();
            gearPos = shifterPos.LOWGEAR;
        }else if(gearPos == shifterPos.LOWGEAR)
        {
            Robot.m_EvoShifter.shiftUp();
            gearPos = shifterPos.HIGHGEAR;
        }
    }

    public boolean gracePeriod()
    {
        double timeSinceGearChanged = timer.get();
        if(timeSinceGearChanged >= 0.5D)
        {
            gearChanged = false;
            timer.stop();
        }
        return gearChanged;

    }

    public Solenoid getSolenoidOut()
    {
        return this.out;
    }
    public Solenoid getSolenoidIn()
    {
        return this.in;
    }

    public static ShifterToggler getInstance()
    {
        if(toggler == null)
            toggler = new ShifterToggler();
        return toggler;
    }

}
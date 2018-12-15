/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.utils.shifterPos;

/**
 * Add your docs here.
 */
public class Shifter_Subsys extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static Shifter_Subsys evo;

  private Solenoid out, in;
  private shifterPos gearPos = shifterPos.HIGHGEAR;

  private Shifter_Subsys()
  {
    this.out = new Solenoid(RobotMap.leftShifterOut);
    this.in = new Solenoid(RobotMap.leftShifterIn);
  }

  public void shiftUp()
  {
    out.set(true);
    in.set(false);
  }

  public void shiftDown()
  {
    out.set(false);
    in.set(true);
  }

  public static Shifter_Subsys getInstance()
  {
    if(evo == null)
    {
      evo = new Shifter_Subsys();
    }
    return evo;
  }

  public void setGearPos(shifterPos pos)
  {
    this.gearPos = pos;
  }
  public shifterPos getGearPos() {
    return gearPos;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

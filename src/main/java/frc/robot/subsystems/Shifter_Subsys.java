/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.utils.ShifterToggler;
import frc.robot.utils.shifterPos;

/**
 * Add your docs here.
 */
public class Shifter_Subsys extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static Shifter_Subsys evo;

  private shifterPos gearPos = shifterPos.HIGHGEAR;
  public ShifterToggler toggler;

  private Shifter_Subsys()
  {
    this.toggler = new ShifterToggler();
  }

  public void shiftUp()
  {
    toggler.getSolenoidOut().set(true);
    toggler.getSolenoidIn().set(false);
  }

  public void shiftDown()
  {
    toggler.getSolenoidOut().set(false);
    toggler.getSolenoidIn().set(true);
  }

  public void togglerGear()
  {
    toggler.toggleGear();
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
  public void printGearPos()
  {
    System.out.println("Current Gear Position: " + gearPos);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

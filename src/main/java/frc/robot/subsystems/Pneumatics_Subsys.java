/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Pneumatics_Subsys extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static Pneumatics_Subsys pneumatics_Subsys;

  private Compressor shiftCompressor;
  private Pneumatics_Subsys()
  {
    this.shiftCompressor = new Compressor(0);
  }

  public void enableCompressor()
  {
    this.shiftCompressor.setClosedLoopControl(true);
  }

  public void disableCompressor()
  {
    this.shiftCompressor.setClosedLoopControl(false);
  }

  public static Pneumatics_Subsys getInstance()
  {
    if(pneumatics_Subsys == null)
        pneumatics_Subsys = new Pneumatics_Subsys();
    return pneumatics_Subsys;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

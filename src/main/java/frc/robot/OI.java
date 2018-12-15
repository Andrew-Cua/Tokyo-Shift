/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private XboxController driveController = new XboxController(0);
  private Button shiftUpButton;
  private Button shiftDownButton;
  private Button compressButton;
  public OI()
  {
    shiftUpButton = new JoystickButton(driveController, 1);
    shiftDownButton = new JoystickButton(driveController, 2);
    compressButton = new JoystickButton(driveController, 6);
    compressButton.whileHeld(new EnableCompressor_Command());
    shiftUpButton.whenReleased(new ShiftUpGear_Command());
    shiftDownButton.whenReleased(new ShiftGear_Command());
  }

  public XboxController getJoystick()
  {
    return this.driveController;
  }
}

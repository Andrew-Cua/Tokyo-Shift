/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.utils.shifterPos;

public class ShiftGear_Command extends Command {
  private shifterPos oldGear = Robot.m_EvoShifter.getGearPos();
  
  public ShiftGear_Command() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_EvoShifter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_EvoShifter.shiftUp();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    /*if(Robot.m_EvoShifter.getGearPos() == shifterPos.HIGHGEAR)
    {
      Robot.m_EvoShifter.shiftDown();
      Robot.m_EvoShifter.setGearPos(shifterPos.LOWGEAR);
    }else if(Robot.m_EvoShifter.getGearPos() == shifterPos.LOWGEAR)
    {
      Robot.m_EvoShifter.shiftUp();
      Robot.m_EvoShifter.setGearPos(shifterPos.HIGHGEAR);
    }*/
    Robot.m_EvoShifter.shiftDown();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    boolean isFinito = false;
    if(Robot.m_EvoShifter.getGearPos() == oldGear)
      isFinito = true;
    return isFinito;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

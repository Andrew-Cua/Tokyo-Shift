/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.*;
/**
 * Add your docs here.
 */
public class Drivetrain_Subsys extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static Drivetrain_Subsys drivetrain;

  private Spark frontLeft, 
                backLeft,
                frontRight,
                backRight;

  private boolean inverted = true;
  private Drivetrain_Subsys()
  {
    this.frontLeft  = new Spark(RobotMap.leftFrontMotor);
    this.backLeft   = new Spark(RobotMap.leftBackMotor);
    this.frontRight = new Spark(RobotMap.rightFrontMotor);
    this.backRight  = new Spark(RobotMap.rightBackMotor);

    this.frontRight.setInverted(inverted);
    this.backRight.setInverted(inverted);

    
    
  }

  private void power(double left, double right)
  {
   this.frontLeft.set(left);
   this.backLeft.set(left);
   this.frontRight.set(right);
   this.backRight.set(right);
  }


  public void teleopDrive()
  {
     double x = Robot.m_oi.getController().getY(Hand.kLeft);
     double rot = Robot.m_oi.getController().getX(Hand.kRight);

     double leftPower = x - rot;
     double rightPower = x + rot;

    power(leftPower, rightPower);
  }

  public void stop()
  {
    power(0,0);
  }

  public void printPower()
  {
    System.out.println("Left Motor Power: " + frontLeft.get());
    System.out.println("Right Motor Power: " + frontRight.get());
  }

  public void run()
  {
    power(1,1);
    System.out.print(frontLeft.get() + frontRight.get());
  }

  public static Drivetrain_Subsys getInstance()
  {
    if(drivetrain == null){
        drivetrain = new Drivetrain_Subsys();
    }
    return drivetrain;
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new teleopDrive_Command());
  }
}

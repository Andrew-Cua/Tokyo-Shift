/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.commands.*;
/**
 * Add your docs here.
 */
public class Drivetrain_Subsys extends PIDSubsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static Drivetrain_Subsys drivetrain;

  private Spark frontLeft, 
                backLeft,
                frontRight,
                backRight;
  private AHRS navX;
  private boolean inverted = true;
  private Drivetrain_Subsys()
  {
    super("Drivetrain", 2.0,0,0);
    setAbsoluteTolerance(0.5);
    getPIDController().setContinuous(false);
    this.frontLeft  = new Spark(RobotMap.leftFrontMotor);
    this.backLeft   = new Spark(RobotMap.leftBackMotor);
    this.frontRight = new Spark(RobotMap.rightFrontMotor);
    this.backRight  = new Spark(RobotMap.rightBackMotor);

    this.navX  = new AHRS(SerialPort.Port.kMXP);

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

  private void PIDwrite(double output)
  {
    frontLeft.pidWrite(output);
    backLeft.pidWrite(output);
    frontRight.pidWrite(output);
    backRight.pidWrite(output);
  }

  protected double returnPIDInput()
  {
    return navX.getAngle();
  }

  protected void usePIDOutput(double output)
  {
    PIDwrite(output);
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

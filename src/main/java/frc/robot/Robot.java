// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;

import edu.wpi.first.wpilibj.Timer;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.ADIS16470_IMU;
import frc.robot.subsystems.Intake;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  XboxController driverController = new XboxController(0);
  TalonSRX fRight = new TalonSRX(4);
  TalonSRX fLeft = new TalonSRX(16);
  TalonSRX bRight = new TalonSRX(3);
  TalonSRX bLeft = new TalonSRX(2);

  PhotonCamera camera = new PhotonCamera("MicrosoftLiveCamHD-3000");

  final double CAMERA_HEIGHT_METERS = Units.inchesToMeters(12);
  final double TARGET_HEIGHT_METERS = Units.feetToMeters(5);

  // Angle between horizontal and the camera.
  final double CAMERA_PITCH_RADIANS = Units.degreesToRadians(45);

  private final Intake intakesubsystem = new Intake();

  public Robot() {
    CameraServer.startAutomaticCapture();

  }
  // ADIS16470_IMU gyro = new ADIS16470_IMU();
  // Timer time = new Timer();
  // CANSparkMax neoController = new CANSparkMax(17, MotorType.kBrushless);

  // /**
  // * This function is run when the robot is first started up and should be used
  // for any
  // * initialization code.
  // */
  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {
    // neoController.setVoltage(0.2);

  }

  @Override
  public void teleopInit() {
    applyDriverInputs();

  }

  @Override
  public void teleopPeriodic() {
    double drive = driverController.getLeftY();
    double rotate = driverController.getRightX();

    fRight.setInverted(true);
    bRight.setInverted(true);

    fRight.set(TalonSRXControlMode.PercentOutput, drive - rotate / 2);
    bRight.set(TalonSRXControlMode.PercentOutput, drive - rotate / 2);
    fLeft.set(TalonSRXControlMode.PercentOutput, drive + rotate / 2);
    bLeft.set(TalonSRXControlMode.PercentOutput, drive + rotate / 2);

    if (driverController.getAButton()) {
      intakesubsystem.runIntake();
    } else if (driverController.getBButton()) {
      intakesubsystem.outIntake();
    } else {
      intakesubsystem.stopIntake();
    }

    // Drift Code

    // double vertical;
    // double horizontal;
    // double pivot;

    // vertical = 0.75 * driverController.getLeftY();
    // horizontal = -0.75 * driverController.getLeftX();
    // pivot = -driverController.getRightX();

    // fRight.set(TalonSRXControlMode.PercentOutput, (pivot + (-vertical +
    // horizontal)));
    // bRight.set(TalonSRXControlMode.PercentOutput, pivot + (-vertical -
    // horizontal));
    // fLeft.set(TalonSRXControlMode.PercentOutput,(-pivot + (-vertical -
    // horizontal)));
    // bLeft.set(TalonSRXControlMode.PercentOutput, (-pivot + (-vertical +
    // horizontal)));

    // Tank Drive

    // double drive = driverController.getLeftY();
    // double rotate = driverController.getRightX();

    // fRight.setInverted(true);
    // bRight.setInverted(true);

    // fRight.set(TalonSRXControlMode.PercentOutput, drive-rotate/2);
    // bRight.set(TalonSRXControlMode.PercentOutput, drive-rotate/2);
    // fLeft.set(TalonSRXControlMode.PercentOutput, drive+rotate/2);
    // bLeft.set(TalonSRXControlMode.PercentOutput, drive+rotate/2);

    // if(driverController.getAButton()){

    // var result = camera.getLatestResult();
    // double range = PhotonUtils.calculateDistanceToTargetMeters(
    // CAMERA_HEIGHT_METERS,
    // TARGET_HEIGHT_METERS,
    // CAMERA_PITCH_RADIANS,
    // Units.degreesToRadians(result.getBestTarget().getPitch()));

    // System.out.println(range);

    // }

  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }

  private void applyDriverInputs() {
  }
}

/*
 * 
 * 

 */

/*
 * 
 * 
 * gyro.reset();
 * time.reset();
 * time.start();
 * 
 * 
 * 
 * 
 * System.out.println(Math.round(gyro.getAngle()));
 * System.out.println(time.get());
 * double angle = Math.round(gyro.getAngle());
 * 
 * fRight.setInverted(true);
 * bRight.setInverted(true);
 * 
 * // while(time.get() < 2){
 * // fLeft.set(TalonSRXControlMode.PercentOutput, 0.2);
 * // bLeft.set(TalonSRXControlMode.PercentOutput, 0.2);
 * // fRight.set(TalonSRXControlMode.PercentOutput, 0.2);
 * // bRight.set(TalonSRXControlMode.PercentOutput, 0.2);
 * // }
 * 
 * while(angle <= 90){
 * double speed = 0.5 - ((angle)/18)/10;
 * fRight.set(TalonSRXControlMode.PercentOutput, speed);
 * bRight.set(TalonSRXControlMode.PercentOutput, speed);
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * // if (angle > 2){
 * // fLeft.set(TalonSRXControlMode.PercentOutput, 0.2);
 * // bLeft.set(TalonSRXControlMode.PercentOutput, 0.2);
 * // fRight.set(TalonSRXControlMode.PercentOutput, 0);
 * // bRight.set(TalonSRXControlMode.PercentOutput, 0);
 * // } else if (angle < -2){
 * // fRight.set(TalonSRXControlMode.PercentOutput, 0.2);
 * // bRight.set(TalonSRXControlMode.PercentOutput, 0.2);
 * // fLeft.set(TalonSRXControlMode.PercentOutput, 0);
 * // bLeft.set(TalonSRXControlMode.PercentOutput, 0);
 * // }else{
 * // fRight.set(TalonSRXControlMode.PercentOutput, 0.2);
 * // fLeft.set(TalonSRXControlMode.PercentOutput, 0.2);
 * // bRight.set(TalonSRXControlMode.PercentOutput, 0.2);
 * // bLeft.set(TalonSRXControlMode.PercentOutput, 0.2);
 * // }
 */
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  private CANSparkMax m_motor;
  private SparkMaxPIDController m_pidController;
  private RelativeEncoder m_encoder;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM, maxVel, minVel, maxAcc, allowedErr;
  
  public Shooter() {
    m_motor = Constants.shooterMotor;
    // m_motor.restoreFactoryDefaults();
    // m_pidController = m_motor.getPIDController();
    // m_encoder = m_motor.getEncoder();
    // kP = 5e-3; 
    // kI = 0;
    // kD = 1; 
    // kIz = 0; 
    // kFF = 0.000156; 
    // kMaxOutput = 1; 
    // kMinOutput = -1;
    // maxRPM = 5700;
    // maxVel = 2000; // rpm
    // maxAcc = 1500;
    // m_pidController.setP(kP);
    // m_pidController.setI(kI);
    // m_pidController.setD(kD);
    // m_pidController.setIZone(kIz);
    // m_pidController.setFF(kFF);
    // m_pidController.setOutputRange(kMinOutput, kMaxOutput);
    // int smartMotionSlot = 0;
    // m_pidController.setSmartMotionMaxVelocity(maxVel, smartMotionSlot);
    // m_pidController.setSmartMotionMinOutputVelocity(minVel, smartMotionSlot);
    // m_pidController.setSmartMotionMaxAccel(maxAcc, smartMotionSlot);
    // m_pidController.setSmartMotionAllowedClosedLoopError(allowedErr, smartMotionSlot);
    // SmartDashboard.putNumber("P Gain", kP);
    // SmartDashboard.putNumber("I Gain", kI);
    // SmartDashboard.putNumber("D Gain", kD);
    // SmartDashboard.putNumber("I Zone", kIz);
    // SmartDashboard.putNumber("Feed Forward", kFF);
    // SmartDashboard.putNumber("Max Output", kMaxOutput);
    // SmartDashboard.putNumber("Min Output", kMinOutput);
    // SmartDashboard.putNumber("Max Velocity", maxVel);
    // SmartDashboard.putNumber("Min Velocity", minVel);
    // SmartDashboard.putNumber("Max Acceleration", maxAcc);
    // SmartDashboard.putNumber("Allowed Closed Loop Error", allowedErr);
    // SmartDashboard.putNumber("Set Position", 0);
    // SmartDashboard.putNumber("Set Velocity", 0);
    // SmartDashboard.putBoolean("Mode", true);
  }
  public void start(int velocity){
    // double p = SmartDashboard.getNumber("P Gain", 0);
    // double i = SmartDashboard.getNumber("I Gain", 0);
    // double d = SmartDashboard.getNumber("D Gain", 0);
    // double iz = SmartDashboard.getNumber("I Zone", 0);
    // double ff = SmartDashboard.getNumber("Feed Forward", 0);
    // double max = SmartDashboard.getNumber("Max Output", 0);
    // double min = SmartDashboard.getNumber("Min Output", 0);
    // double maxV = SmartDashboard.getNumber("Max Velocity", 0);
    // double minV = SmartDashboard.getNumber("Min Velocity", 0);
    // double maxA = SmartDashboard.getNumber("Max Acceleration", 0);
    // double allE = SmartDashboard.getNumber("Allowed Closed Loop Error", 0);
    // if((p != kP)) { m_pidController.setP(p); kP = p; }
    // if((i != kI)) { m_pidController.setI(i); kI = i; }
    // if((d != kD)) { m_pidController.setD(d); kD = d; }
    // if((iz != kIz)) { m_pidController.setIZone(iz); kIz = iz; }
    // if((ff != kFF)) { m_pidController.setFF(ff); kFF = ff; }
    // if((max != kMaxOutput) || (min != kMinOutput)) { 
    //   m_pidController.setOutputRange(min, max); 
    //   kMinOutput = min; kMaxOutput = max; 
    // }
    // if((maxV != maxVel)) { m_pidController.setSmartMotionMaxVelocity(maxV,0); maxVel = maxV; }
    // if((minV != minVel)) { m_pidController.setSmartMotionMinOutputVelocity(minV,0); minVel = minV; }
    // if((maxA != maxAcc)) { m_pidController.setSmartMotionMaxAccel(maxA,0); maxAcc = maxA; }
    // if((allE != allowedErr)) { m_pidController.setSmartMotionAllowedClosedLoopError(allE,0); allowedErr = allE; }
    // double setPoint, processVariable;
    // boolean mode = SmartDashboard.getBoolean("Mode", false);
    // if(mode) {
    //   setPoint = SmartDashboard.getNumber("Set Velocity", velocity);
    //   m_pidController.setReference(velocity, CANSparkMax.ControlType.kVelocity);
    //   processVariable = m_encoder.getVelocity();
    // } else {
    //   setPoint = SmartDashboard.getNumber("Set Position", 0);
    //   m_pidController.setReference(setPoint, CANSparkMax.ControlType.kSmartMotion);
    //   processVariable = m_encoder.getPosition();
    // }
    // SmartDashboard.putNumber("SetPoint", setPoint);
    // SmartDashboard.putNumber("Process Variable", processVariable);
    // SmartDashboard.putNumber("Output", m_motor.getAppliedOutput());
    m_motor.set(0.8);
    SmartDashboard.putString("Status Shooter", "Working!!");
  }
  public void stop(){
    m_motor.set(0.0);
    SmartDashboard.putString("Status Shooter", "Stoped!!");
  }
  public boolean finish(){
    return (m_encoder.getPosition() > 20000000);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Lifter extends SubsystemBase {
  private CANSparkMax m_motor;
  private RelativeEncoder m_encoder;
  public Lifter() {
    m_motor = Constants.lifterMotor;
    m_motor.setIdleMode(IdleMode.kBrake);
    m_encoder = m_motor.getEncoder();
  }
  public void moveUp(){
    m_motor.set(-1);
  }
  public void moveDown(){
    m_motor.set(1);
  }
  public void stop(){
    m_motor.set(0);
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

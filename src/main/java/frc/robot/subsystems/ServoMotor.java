// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ServoMotor extends SubsystemBase {
  private Servo motorservo;
  /** Creates a new ExampleSubsystem. */
  public ServoMotor() {
    motorservo = Constants.servo_motor;
  }
  public void posicion1(){
    motorservo.set(30);
  }
  public void posicion2(){
    motorservo.set(0);
  }
  public boolean finish(){
    return (motorservo.getAngle() >= 30);
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

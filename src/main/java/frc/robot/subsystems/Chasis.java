// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Chasis extends SubsystemBase {
    private  CANSparkMax chassisMotorL;
    private  CANSparkMax chassisMotorL2;
    private  CANSparkMax chassisMotorR;
    private  CANSparkMax chassisMotorR2;
    private  RelativeEncoder encoderR;
    private RelativeEncoder encoderL;
  public Chasis() {
    chassisMotorL = Constants.chassisMotorL;
    chassisMotorL2 = Constants.chassisMotorL2;
    chassisMotorR = Constants.chassisMotorR;
    chassisMotorR2 = Constants.chassisMotorR2;
    chassisMotorL.setOpenLoopRampRate(0.1);
    chassisMotorL2.setOpenLoopRampRate(0.1);
    chassisMotorR.setOpenLoopRampRate(0.1);
    chassisMotorR2.setOpenLoopRampRate(0.1);
    encoderL = chassisMotorL2.getEncoder();
    encoderR = chassisMotorR.getEncoder();
    encoderL.setPosition(0);
    encoderR.setPosition(0);
  }
  public void encoderRreset(){
    encoderR.setPosition(0.0);
    encoderL.setPosition(0.0);
  }
  public void move(double x, double y){
    double speed1 = (y - (x * 0.8));
    double speed2 = (y + (x * 0.8)); 
    if(y<= 0.1 && y >= -0.1 && x <= 0.1 && x >= -0.1){
      chassisMotorL.set(0);
      chassisMotorL2.set(0);
      chassisMotorR.set(0);
      chassisMotorR2.set(0);
    }else{
      chassisMotorL.set(speed1);
      chassisMotorL2.set(speed1);
      chassisMotorR.set(speed2);
      chassisMotorR2.set(speed2);
    }
    SmartDashboard.putNumber("Encoder L", encoderL.getPosition());
    SmartDashboard.putNumber("Encoder R", encoderR.getPosition());
    SmartDashboard.putNumber("Servo alngle", Constants.servo_motor.getAngle());
  }
  public void turnL(double angle){
    double r = (angle * (15.000003/2) / 81) + 14;
    double total = encoderR.getPosition() + r;
    if(encoderR.getPosition() >= total){
      chassisMotorL.set(0.4);
      chassisMotorL2.set(0.4);
      chassisMotorR.set(0.4);
      chassisMotorR2.set(0.4);
    }else{
      chassisMotorL.set(0);
      chassisMotorL2.set(0);
      chassisMotorR.set(0);
      chassisMotorR2.set(0);
    }
    SmartDashboard.putNumber("Encoder L", encoderL.getPosition());
    SmartDashboard.putNumber("Encoder R", encoderR.getPosition());
  }
  public void moveback(double rotation){
    if(encoderR.getPosition() <= rotation){
      chassisMotorL.set(-0.1);
      chassisMotorL2.set(-0.1);
      chassisMotorR.set(0.1);
      chassisMotorR2.set(0.1);
      SmartDashboard.putNumber("Encoder L", encoderL.getPosition());
      SmartDashboard.putNumber("Encoder R", encoderR.getPosition());
    }else{
      chassisMotorL.set(0);
      chassisMotorL2.set(0);
      chassisMotorR.set(0);
      chassisMotorR2.set(0);
    }
  }
  public void stop(){
    chassisMotorL.set(0);
    chassisMotorL2.set(0);
    chassisMotorR.set(0);
    chassisMotorR2.set(0);
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

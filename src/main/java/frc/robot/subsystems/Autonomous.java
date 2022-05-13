// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Autonomous extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private Timer timer;
  public Autonomous() {
    timer = new Timer();
    timer.reset();
  }
  public void startTimer(){
    timer.start();
    Robot.m_chasis.encoderRreset();
  }

  public void start(){
    if(timer.get() <= 6){
      Robot.m_chasis.moveback(38);
    }else if(timer.get() >= 6 && timer.get() <= 10){
      Robot.m_shooter.start(2700);
    }else if(timer.get() >= 11 && timer.get() <= 11.5){
      Robot.m_shooter.stop();
    }else if(timer.get() >= 11.5 && timer.get() <= 15){
      Robot.m_chasis.turnL(190);
    }
    SmartDashboard.putNumber("Seconds", timer.get());
  }
  public void end(){
    timer.stop();
  }
  public boolean finish(){
    return (timer.get() >= 15);
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

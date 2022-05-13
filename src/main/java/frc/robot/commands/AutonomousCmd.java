// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Autonomous;
import frc.robot.subsystems.Chasis;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutonomousCmd extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Autonomous m_subsystem;
  private final Chasis m_chasis;
  private final Shooter m_shooter;
  private Timer timer;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutonomousCmd(Autonomous subsystem, Chasis chasis, Shooter shooter) {
    m_subsystem = subsystem;
    m_chasis = chasis;
    m_shooter = shooter;
    timer = new Timer();
    timer.reset();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    addRequirements(chasis);
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.start();
   }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.get() <= 6){
      m_chasis.moveback(38);
    }else if(timer.get() >= 6 && timer.get() <= 10){
      m_shooter.start(3500);
    }else if(timer.get() >= 11 && timer.get() <= 11.5){
      m_shooter.stop();
    }else if(timer.get() >= 11.5 && timer.get() <= 15){
      
    } 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(interrupted){
      m_chasis.stop();
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (timer.get() >= 15);
  }
}

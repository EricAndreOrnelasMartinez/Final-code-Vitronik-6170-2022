// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.LifterDown;
import frc.robot.commands.LifterUp;
import frc.robot.commands.ServoPosicionDos;
import frc.robot.commands.ServoPosicionUno;
import frc.robot.commands.Shoot;
import frc.robot.commands.TakeIn;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public static Joystick control1;
  public static Joystick control2;
  public JoystickButton b1;
  public JoystickButton b2;
  public JoystickButton b3;
  public JoystickButton b4;
  public JoystickButton b5;
  public JoystickButton b6;

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    control1 = new Joystick(0);
    control2 = new Joystick(1);
    configureButtonBindings();
  }
 
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    b1 = new JoystickButton(control2, 1);
    b1.whileHeld(new LifterDown(Robot.m_lifter));
    b2 = new JoystickButton(control2, 2);
    b2.whileHeld(new Shoot(Robot.m_shooter, 3500));
    b3 = new JoystickButton(control2, 3);
    b3.whileHeld(new TakeIn(Robot.m_intake));
    b4 = new JoystickButton(control2, 4);
    b4.whileHeld(new LifterUp(Robot.m_lifter));
    b5 = new JoystickButton(control2, 5);
    b5.whileHeld(new Shoot(Robot.m_shooter, 2000));
    //b5.whileHeld(new ServoPosicionUno(Robot.m_servomotor));
    //b6 = new JoystickButton(control2, 6);
    //b6.whileHeld(new ServoPosicionDos(Robot.m_servomotor));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}

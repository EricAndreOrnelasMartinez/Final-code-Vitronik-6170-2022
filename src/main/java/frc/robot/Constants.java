// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
import edu.wpi.first.wpilibj.Servo;
public final class Constants {
    private static final int deviceNumberCL = 0;
    private static final int deviceNumberCL2 = 4;
    private static final int deviceNumberCR = 2;
    private static final int deviceNumberCR2 = 8;
    private static final int deviceNumberST = 6;
    private static final int deviceNumberIt = 5;
    private static final int deviceNumberFt = 3;
    private static final int channelDIOUp = 8;
    private static final int channelDIOD = 7    ;
    
    private static final int canal_servo = 9;
      

    public static CANSparkMax chassisMotorL;
    public static CANSparkMax chassisMotorL2;
    public static CANSparkMax chassisMotorR;
    public static CANSparkMax chassisMotorR2;
    public static CANSparkMax shooterMotor;
    public static Compressor compressor;
    public static TalonSRX intakeMotor;
    public static CANSparkMax lifterMotor;
    public static DigitalInput limitUp;
    public static DigitalInput limitDown;

    public static Servo servo_motor;

    public static void init(){
        chassisMotorL = new CANSparkMax(deviceNumberCL,  MotorType.kBrushless);
        chassisMotorL2 = new CANSparkMax(deviceNumberCL2, MotorType.kBrushless);
        chassisMotorR = new CANSparkMax(deviceNumberCR, MotorType.kBrushless);
        chassisMotorR2 = new CANSparkMax(deviceNumberCR2, MotorType.kBrushless);
        shooterMotor = new CANSparkMax(deviceNumberST, MotorType.kBrushless);
        compressor = new Compressor(0,PneumaticsModuleType.CTREPCM);
        intakeMotor = new TalonSRX(deviceNumberIt);
        lifterMotor = new CANSparkMax(deviceNumberFt, MotorType.kBrushless);
        limitUp = new DigitalInput(channelDIOUp);
        limitDown = new DigitalInput(channelDIOD);
        
        servo_motor = new Servo(canal_servo);
    }
}

package org.firstinspires.ftc.teamcode.mechanisims;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.*;

public class TestBench{

    // Right artifact servo
    private CRServo right_servo;
    // Launcher motor
    private DcMotor motor;

    private DcMotor intake;

    // Drive motors
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    private IMU imu;

    public void init(HardwareMap hwMap) {
        // Setup launcher motor
        motor = hwMap.get(DcMotor.class, "launcher");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Assign to class fields (no "DcMotor" type declaration here)
        frontLeftMotor = hwMap.get(DcMotor.class, "left_front");
        frontRightMotor = hwMap.get(DcMotor.class, "right_front");
        backLeftMotor = hwMap.get(DcMotor.class, "left_back");
        backRightMotor = hwMap.get(DcMotor.class, "right_back");

        // Direction configuration
        frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Set zero power behavior for drive motors
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intake = hwMap.get(DcMotor.class, "intake");
        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        right_servo = hwMap.get(CRServo.class, "right_feeder");

        imu = hwMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.LEFT , RevHubOrientationOnRobot.UsbFacingDirection.UP);

        }


    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }

    public void setRightServoPower(double power) {
        if (right_servo != null) {
            right_servo.setPower(power);
        }
    }

    public void driveMecanum(double drive, double strafe, double turn) {
        // Standard mecanum kinematics:
        // FL = y + x + rx
        // FR = y - x - rx
        // BL = y - x + rx
        // BR = y + x - rx
        frontLeftMotor.setPower(drive + strafe + turn);
        frontRightMotor.setPower(drive - strafe - turn);
        backLeftMotor.setPower(drive - strafe + turn);
        backRightMotor.setPower(drive + strafe - turn);
    }

    public void intakeBallz(double power){
        intake.setPower(power);
    }

    public void setRight_servo(double power, int dir){
        if (dir> 0){
            right_servo.setDirection(DcMotorSimple.Direction.FORWARD);
        }
        else{
            right_servo.setDirection(DcMotorSimple.Direction.REVERSE);
        }
        right_servo.setPower(power);
    }
}


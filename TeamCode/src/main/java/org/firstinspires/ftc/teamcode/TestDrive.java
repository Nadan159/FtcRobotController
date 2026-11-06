package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.mechanisims.TestBench;

@TeleOp(name = "Test Drive", group = "TeleOp")
public class TestDrive extends OpMode {

    TestBench bench = new TestBench();

    @Override
    public void init() {
        bench.init(hardwareMap);

        telemetry.addData("status", "initialized");
        telemetry.update();
    }

    @Override
    public void loop() {
        // Note: FTC gamepad Y-axis is inverted (up is -1.0)
        double drive = gamepad1.left_stick_y; // Forward / Back
        double strafe = -gamepad1.left_stick_x;  // Left / Right
        double turn = -gamepad1.right_stick_x;   // Turn

        bench.driveMecanum(drive, strafe, turn);

        telemetry.addData("Drive", drive);
        telemetry.addData("Strafe", strafe);
        telemetry.addData("Turn", turn);
        telemetry.update();

        bench.setMotorSpeed(gamepad1.right_trigger);
        bench.setRightServoPower(gamepad1.right_stick_y);
        bench.intakeBallz(gamepad1.left_trigger);
    }
}
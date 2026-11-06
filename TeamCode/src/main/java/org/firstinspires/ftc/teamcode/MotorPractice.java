package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.mechanisims.TestBench;

@TeleOp
public class MotorPractice extends OpMode {
    TestBench bench = new TestBench();

    @Override
    public void init(){
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        bench.setMotorSpeed(gamepad1.left_stick_y);
    }
}

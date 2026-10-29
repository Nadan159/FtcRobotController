package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class GamepadPractice extends OpMode {

    @Override
    public void init(){

    }

    @Override

    public void loop(){
        telemetry.addData("X gamepad left :",gamepad1.left_stick_x);
        telemetry.addData("Y gamepad left :",gamepad1.left_stick_y);
        telemetry.addData("X gamepad right:",gamepad1.right_stick_x);
        telemetry.addData("Y gamepad right:",gamepad1.right_stick_y);
        telemetry.addData("Circle button",gamepad1.b);
        telemetry.addData("Cross button",gamepad1.a);
        telemetry.addData("Square button",gamepad1.x);
        telemetry.addData("Triangle button",gamepad1.y);
    }
}
//to set gamepad 1 use option + cross
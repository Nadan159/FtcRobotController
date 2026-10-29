package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class VarEX extends OpMode {
    @Override
    public void init(){
        int teamNumber = 23705;

        telemetry.addData("team number",teamNumber);
    }

    public void loop(){

    }
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class IfPractice extends OpMode {

    @Override
    public void init(){

    }

    @Override
    public void loop(){


//        setup vars

        double LeftY = gamepad1.left_stick_y;
        boolean CrossButtonPressed = gamepad1.a;

//        first if statement

        if (CrossButtonPressed) {

            telemetry.addData(" Cross is", "pressed");
        }

        else{
            telemetry.addData("Cross is", "Not pressed / sad / depressed");
        }


        if (LeftY > 0){
            telemetry.addData("left Y bigger than 0 ", "True");

        }

        else {
            telemetry.addData("left Y bigger than 0 ", "False");
        }

        


    }

}

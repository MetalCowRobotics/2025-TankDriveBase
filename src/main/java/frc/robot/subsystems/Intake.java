package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.ADIS16470_IMU;
    public class Intake {
        private VictorSPX intakemotor = new VictorSPX(10);

        public Intake() {


        }

        public void runIntake() {
            intakemotor.set(ControlMode.PercentOutput, 0.5);
        }
        
        public void outIntake() {
            intakemotor.set(ControlMode.PercentOutput, -0.5);
        }

        public void stopIntake() {
            intakemotor.set(ControlMode.PercentOutput, 0);
        }

        public void periodic() {

        }

    }

    


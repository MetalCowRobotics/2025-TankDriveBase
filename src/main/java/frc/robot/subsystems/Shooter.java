package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
public class Shooter {
    public static double speed;
    VictorSPX shooterpivot = new VictorSPX(2);
    VictorSPX shooter = new VictorSPX(3);

    public Shooter() {
        shooterpivot.set(ControlMode.PercentOutput, speed);
    }

    public void shooterPivot() {
        shooterpivot.set(ControlMode.PercentOutput, speed);
    }

    public void shooterIntake() {
        shooter.set(ControlMode.PercentOutput, 0.55);
    }

    public void shoot() {
        shooter.set(ControlMode.PercentOutput, -2);
    }

    public void stop() {
        shooter.set(ControlMode.PercentOutput, 0);
    }
}

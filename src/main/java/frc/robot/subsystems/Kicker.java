package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
public class Kicker {
    private VictorSPX kicker = new VictorSPX(6);
    public Kicker() {
        
    }
    public void runkicker(){
        kicker.set(ControlMode.PercentOutput, -0.3);
    }
    public void stopkicker(){
        kicker.set(ControlMode.PercentOutput, 0);
    }
}

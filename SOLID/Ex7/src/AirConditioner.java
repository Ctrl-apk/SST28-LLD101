public class AirConditioner implements PowerControl,TemperatureController {
    public void powerOn() { /* ok */ }
    public void powerOff() { System.out.println("AC OFF"); }
    public void setTemperatureC(int c) { System.out.println("AC set to " + c + "C"); }
}

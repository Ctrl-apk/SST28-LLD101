public class Projector implements PowerControl,AttendanceController,InputController {
    private boolean on;

    @Override public void powerOn() { on = true; }
    @Override public void powerOff() { on = false; System.out.println("Projector OFF"); }

//    @Override public void setBrightness(int pct) { /* irrelevant */ }
//    @Override public void setTemperatureC(int c) { /* irrelevant */ }
    public int scanAttendance() { return 0; } // dummy
    public void connectInput(String port) { if (on) System.out.println("Projector ON (" + port + ")"); }
}

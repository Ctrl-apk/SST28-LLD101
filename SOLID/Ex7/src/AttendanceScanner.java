public class AttendanceScanner implements PowerControl,AttendanceController{
    @Override public void powerOn() { /* ok */ }
    @Override public void powerOff() { /* no output */ }

    public int scanAttendance() { return 3; }
}

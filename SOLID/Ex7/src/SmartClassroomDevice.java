interface InputController {
    void connectInput(String port);
}
interface PowerControl{
    void powerOn();
    void powerOff();
}

interface BrightnessController{
    void setBrightness(int pct);
}
interface TemperatureController{
    void setTemperatureC(int c);
}
interface AttendanceController{
    int scanAttendance();
}
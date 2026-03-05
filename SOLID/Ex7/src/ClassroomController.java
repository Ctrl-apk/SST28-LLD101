public class ClassroomController {
    private final DeviceRegistry reg;


    public ClassroomController(DeviceRegistry reg) {
        this.reg = reg;
    }

    public void startClass() {
        PowerControl pj = (PowerControl) reg.getFirstOfType("Projector");
        InputController input = (InputController) reg.getFirstOfType("Projector");
        pj.powerOn();
        input.connectInput("HDMI-1");

        BrightnessController lights = (BrightnessController) reg.getFirstOfType("LightsPanel");
        lights.setBrightness(60);

        TemperatureController ac = (TemperatureController) reg.getFirstOfType("AirConditioner");
        ac.setTemperatureC(24);

        AttendanceController scan = (AttendanceController) reg.getFirstOfType("AttendanceScanner");
        System.out.println("Attendance scanned: present=" + scan.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        ((PowerControl)reg.getFirstOfType("Projector")).powerOff();
        ((PowerControl)reg.getFirstOfType("LightsPanel")).powerOff();
        ((PowerControl)reg.getFirstOfType("AirConditioner")).powerOff();
    }
}

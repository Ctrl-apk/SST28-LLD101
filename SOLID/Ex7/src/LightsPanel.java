public class LightsPanel implements PowerControl,BrightnessController {
    @Override public void powerOn() { /* always on */ }
    @Override public void powerOff() { System.out.println("Lights OFF"); }

    public void setBrightness(int pct) { System.out.println("Lights set to " + pct + "%"); }
}

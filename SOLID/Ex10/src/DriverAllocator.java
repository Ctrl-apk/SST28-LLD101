public class DriverAllocator implements DriverAllocatorStrategy{
    public String allocate(String studentId) {
        // fake deterministic driver
        return "DRV-17";
    }
}

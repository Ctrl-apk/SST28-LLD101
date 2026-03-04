public class TransportBookingService {
    private final DistanceCalculatorStrategy dist;
    private final DriverAllocatorStrategy alloc;
    private final PaymentGatewayStrategy pay;

    public TransportBookingService(DistanceCalculatorStrategy dist,DriverAllocatorStrategy alloc,PaymentGatewayStrategy pay){
        this.dist=dist;
        this.alloc=alloc;
        this.pay=pay;
    }
    // DIP violation: direct concretes
    public void book(TripRequest req) {

        double km = dist.km(req.from, req.to);
        System.out.println("DistanceKm=" + km);

        String driver = alloc.allocate(req.studentId);
        System.out.println("Driver=" + driver);

        double fare = 50.0 + km * 6.6666666667; // messy pricing
        fare = Math.round(fare * 100.0) / 100.0;

        String txn = pay.charge(req.studentId, fare);
        System.out.println("Payment=PAID txn=" + txn);

        BookingReceipt r = new BookingReceipt("R-501", fare);
        System.out.println("RECEIPT: " + r.id + " | fare=" + String.format("%.2f", r.fare));
    }
}
interface DistanceCalculatorStrategy{
    double km(GeoPoint a, GeoPoint b);
}
interface DriverAllocatorStrategy{
    String allocate(String studentId);
}
interface PaymentGatewayStrategy{
    String charge(String studentId, double amount);
}
//DIP??
// high level shouldnt depend on low level,both should depend on abstraction
//abstr shiudlnt depe on implement but implement should depend on abs

// high and low should depend on abstraction not actuaal; implementation
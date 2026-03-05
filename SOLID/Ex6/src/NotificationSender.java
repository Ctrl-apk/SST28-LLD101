public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
    public abstract void send(Notification n);
}
//LSP??
// how to inherit properly?? for this puprpose it is there
// if wrongly inheritr=ed then  LSP violated
// if i have Class C which has void x(){..}
// i inherited C1 extends C and C2 extends C then C1.x() abs c2.x() should not break
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Club Admin ===");
        BudgetLedger ledger = new BudgetLedger();
        MinutesBook minutes = new MinutesBook();
        EventPlanner events = new EventPlanner();

        BudgetTracker treasurer = new TreasurerTool(ledger);
        MinutesStrategy secretary = new SecretaryTool(minutes);
        EventLeadTool eventLead = new EventLeadTool(events);

        ClubConsole console = new ClubConsole(treasurer,secretary,eventLead,eventLead);
        console.run();
    }
}

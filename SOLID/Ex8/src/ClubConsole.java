public class ClubConsole {
    private final BudgetTracker treasurer;
    private final MinutesStrategy secretary;
    private final EventCreationStrategy lead;
    private final EventTracker tracker;

    public ClubConsole(BudgetTracker treasurer, MinutesStrategy secretary, EventCreationStrategy lead, EventTracker tracker) {
        this.treasurer = treasurer;
        this.secretary = secretary;
        this.lead = lead;
        this.tracker = tracker;
    }

    public void run() {

        treasurer.addIncome(5000, "sponsor");
        secretary.addMinutes("Meeting at 5pm");
        lead.createEvent("HackNight", 2000);

        System.out.println("Summary: ledgerBalance=" + treasurer.balanceInt() + ", minutes=" + secretary.count() + ", events=" + tracker.getEventsCount());
    }
}

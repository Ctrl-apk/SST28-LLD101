interface MinutesStrategy {
    void addMinutes(String text);
    int count();
}
interface EventCreationStrategy{
    void createEvent(String name, double budget);
}
interface BudgetTracker{
    void addIncome(double amt, String note);
    void addExpense(double amt, String note);
    int balanceInt();
}
interface EventTracker {
    int getEventsCount();
}

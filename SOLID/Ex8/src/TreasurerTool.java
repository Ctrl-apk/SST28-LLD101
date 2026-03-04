public class TreasurerTool implements BudgetTracker {
    private final BudgetLedger ledger;
    public TreasurerTool(BudgetLedger ledger) { this.ledger = ledger; }

    public void addIncome(double amt, String note) { ledger.add(amt, note); }
    public void addExpense(double amt, String note) { ledger.add(-amt, note); }
    public int balanceInt() {return ledger.balanceInt();}
}

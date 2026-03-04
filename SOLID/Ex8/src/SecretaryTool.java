public class SecretaryTool implements MinutesStrategy {
    private final MinutesBook book;
    public SecretaryTool(MinutesBook book) { this.book = book; }

    @Override public void addMinutes(String text) { book.add(text); }

    public int getEventsCount() { return 0; }

    public int count() {return book.count();}
}

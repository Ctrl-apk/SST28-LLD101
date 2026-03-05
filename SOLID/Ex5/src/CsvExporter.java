import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        String csv = "title,body\n" + escape(req.title) + "," + escape(req.body) + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }
    private String escape(String text){
        if(text==null) return "";
        text = text.replace("\"","\"\"");// escapingh quotes
        return "\"" + text +"\"";
    }
}
//Suppose:
//title = Hello
//body = He said "Welcome, friend"

//Step 1 — escape quotes
//He said ""Welcome, friend""

//Step 2 — wrap in quotes
//"He said ""Welcome, friend"""

//Final CSV
//title,body
//"Hello","He said ""Welcome, friend"""
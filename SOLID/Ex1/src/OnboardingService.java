import java.util.*;

public class OnboardingService {
    private final FakeDb db;

    public OnboardingService(FakeDb db) {
        this.db = db;
    }
    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        InputParsing parser = new InputParsing();
        Validator validator = new Validator();
        SaveRecord saver = new SaveRecord();
        Printer printer = new Printer();

        Map<String,String> kv = parser.parse(raw);
        List<String> errors = validator.Validate(kv);
        StudentRecord rec= null;
        if(errors.isEmpty()){
            rec = saver.saveDb(db,kv);
        }
        printer.print(db,errors,rec,raw);
    }
}
class InputParsing{
    public Map<String, String> parse(String raw) {
        Map<String, String> kv = new LinkedHashMap<>();
        String[] parts = raw.split(";");
        for (String p : parts) {
            String[] t = p.split("=", 2);
            if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
        }
        return kv;
    }
}
class Validator{
    public List<String> Validate(Map<String, String> kv){
        // validation inline, printing inline
        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        List<String> errors = new ArrayList<>();
        if (name.isBlank()) errors.add("name is required");
        if (email.isBlank() || !email.contains("@")) errors.add("email is invalid");
        if (phone.isBlank() || !phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(program.equals("CSE") || program.equals("AI") || program.equals("SWE"))) errors.add("program is invalid");
        return errors;
    }
}
class Printer{
    public void print(FakeDb db,List<String> errors,StudentRecord rec,String raw){
        System.out.println("INPUT: " + raw);
        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return;
        }
        System.out.println("OK: created student " + rec.id);
        System.out.println("Saved. Total students: " + db.count());
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
class SaveRecord{
    public StudentRecord saveDb(FakeDb db,Map<String,String> kv){
        String name = kv.get("name");
        String email = kv.get("email");
        String phone = kv.get("phone");
        String program = kv.get("program");

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);
        db.save(rec);
        return  rec;
    }
}

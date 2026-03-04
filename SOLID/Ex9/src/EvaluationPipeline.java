public class EvaluationPipeline {
    // DIP violation: high-level module constructs concretes directly
    private final RubricStrategy rubric;
    private final PlagiarismStrategy pc;
    private final CodeGraderStrategy grader;
    private final ReportWriterStrategy writer;

    public EvaluationPipeline(RubricStrategy rubric,PlagiarismStrategy pc,CodeGraderStrategy grader,ReportWriterStrategy writer) {
        this.rubric = rubric;
        this.pc=pc;
        this.grader=grader;
        this.writer=writer;
    }

    public void evaluate(Submission sub) {
//        Rubric rubric = new Rubric();
//        PlagiarismChecker pc = new PlagiarismChecker();
//        CodeGrader grader = new CodeGrader();
//        ReportWriter writer = new ReportWriter();

        int plag = pc.check(sub);
        System.out.println("PlagiarismScore=" + plag);

        int code = grader.grade(sub, rubric);
        System.out.println("CodeScore=" + code);

        String reportName = writer.write(sub, plag, code);
        System.out.println("Report written: " + reportName);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}
interface RubricStrategy{
    final int bonus=28;
}
interface PlagiarismStrategy{
    int check(Submission s);
}
interface CodeGraderStrategy{
    int grade(Submission s, RubricStrategy r);
}
interface ReportWriterStrategy{
    String write(Submission s, int plag, int code);
}

public class Student {
    private static int idx;
    private int student_code;
    private String student_name;
    private subject required_lesson;
    private subject optional_lesson;
    private subject experimental_lesson;
    private double total_goal;

    public Student(String name, subject _required_lesson, subject _optional_lesson, subject _experimental_lesson) {
        student_name = name;
        setStudent_code();
        required_lesson = new subject(_required_lesson);
        optional_lesson = new subject(_optional_lesson);
        experimental_lesson = new subject(_experimental_lesson);
        total_goal = 0.5 * Math.max(0, required_lesson.getGrade()) + 0.2 * Math.max(0, optional_lesson.getGrade())
                + 0.3 * Math.max(0, experimental_lesson.getGrade());
    }

    public void setStudent_code() {
        student_code = ++idx;
    }

    public double getTotal_goal() {
        return total_goal;
    }

    public String getStudent_name() {
        return student_name;
    }

    public int getStudent_code() {
        return student_code;
    }

    public subject getExperimental_lesson() {
        return experimental_lesson;
    }

    public subject getOptional_lesson() {
        return optional_lesson;
    }

    public subject getRequired_lesson() {
        return required_lesson;
    }

    public void print() {
        System.out.printf("%03d  ", this.getStudent_code());
        System.out.print(this.getStudent_name() + "\t ");
        this.getRequired_lesson().print();
        this.getOptional_lesson().print();
        this.getExperimental_lesson().print();
        System.out.print(this.getTotal_goal() + "\n ");
    }
}

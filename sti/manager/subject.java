
public class subject {
    private String name;
    private int grade;

    public subject() {
    };

    public subject(subject _subject) {
        setName(_subject.name);
        setGrade(_subject.grade);
    }

    public subject(String _name, int _grade) {
        setName(_name);
        setGrade(_grade);
    }

    public int getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void print() {
        System.out.print(this.grade + " \t");
    }

}

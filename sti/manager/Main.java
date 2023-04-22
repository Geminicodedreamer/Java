
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static ArrayList<Student> arrayList = new ArrayList<Student>();
    private static String required_subject_name;
    private static String optional_subject_name;
    private static String experimental_subject_name;

    public static int data_in_required(Scanner sc) {
        int required_subject_grade = -1;
        boolean is_True = true;
        while (is_True) {
            try {
                System.out.print("请输入学生必修科目" + required_subject_name + "成绩 : ");
                required_subject_grade = sc.nextInt();
                is_True = false;
                if (required_subject_grade > 100 || required_subject_grade < -1) {
                    System.out.println("无效输入，请重新输入");
                    is_True = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("无效输入，请重新输入");
                sc.nextLine();
            }
        }
        return required_subject_grade;
    }

    public static int data_in_optional(Scanner sc) {
        int optional_subject_grade = -1;
        boolean is_True = true;
        while (is_True) {
            try {
                System.out.print("请输入学生选修科目" + optional_subject_name + "成绩 : ");
                optional_subject_grade = sc.nextInt();
                is_True = false;
                if (optional_subject_grade > 100 || optional_subject_grade < -1) {
                    System.out.println("无效输入，请重新输入");
                    is_True = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("无效输入，请重新输入");
                sc.nextLine();
            }
        }
        return optional_subject_grade;
    }

    public static int data_in_experimental(Scanner sc) {
        int experimental_subject_grade = -1;
        boolean is_True = true;
        while (is_True) {
            try {
                System.out.print("请输入学生实验课科目" + experimental_subject_name + "成绩 : ");
                experimental_subject_grade = sc.nextInt();
                is_True = false;
                if (experimental_subject_grade > 100 || experimental_subject_grade < -1) {
                    System.out.println("无效输入，请重新输入");
                    is_True = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("无效输入，请重新输入");
                sc.nextLine();
            }
        }
        return experimental_subject_grade;

    }

    public static void data_in(Scanner sc) {
        System.out.print("请输入学生姓名 : ");
        String name = sc.next();
        int required_subject_grade = data_in_required(sc);
        int optional_subject_grade = data_in_optional(sc);
        int experimental_subject_grade = data_in_experimental(sc);
        arrayList.add(new Student(name, new subject(required_subject_name, required_subject_grade),
                new subject(optional_subject_name, optional_subject_grade),
                new subject(experimental_subject_name, experimental_subject_grade)));
    }

    public static void init() {
        System.out.println("欢迎来到学生成绩管理界面 ---");
        System.out.println("请输入本次考试的三个科目的名称 : ");
        System.out.print("必修科目 : ");
        Scanner sc = new Scanner(System.in);
        required_subject_name = sc.next();
        System.out.print("选修科目 : ");
        optional_subject_name = sc.next();
        System.out.print("实验课科目 : ");
        experimental_subject_name = sc.next();
        System.out.println("");
        add_into_form(sc);
    }

    public static void add() {
        Scanner sc = new Scanner(System.in);
        add_into_form(sc);
    }

    private static void add_into_form(Scanner sc) {
        boolean is_first = true;
        while (true) {
            if (is_first) {
                data_in(sc);
                is_first = false;
            } else {
                System.out.print("是否继续输入成绩 : ");
                String op = sc.next();
                if (op.equals("是")) {
                    data_in(sc);
                } else {
                    break;
                }
            }
        }
    }

    public static void sort_the_form() {
        System.out.print("按照什么排序(学号、姓名、综合评分、" + required_subject_name + "成绩、" + optional_subject_name + "成绩、"
                + experimental_subject_name + "成绩)");
        String op = new Scanner(System.in).next();
        if (op.equals("学号"))
            sort_rank_code();
        else if (op.equals("姓名"))
            sort_rank_name();
        else if (op.equals("综合评分"))
            sort_rank_goal();
        else if (op.equals(required_subject_name + "成绩"))
            sort_rank_required();
        else if (op.equals(optional_subject_name + "成绩"))
            sort_rank_optional();
        else if (op.equals(experimental_subject_name + "成绩"))
            sort_rank_experimental();
        else {
            System.out.println("无效内容,请重新输入");
            sort_the_form();
        }
    }

    public static void sort_rank_code() {
        arrayList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if (a.getStudent_code() - b.getStudent_code() > 0)
                    return 1;
                else
                    return -1;
            }
        });
        print();
    }

    public static void sort_rank_name() {
        arrayList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                for (int i = 0; i < Math.min(a.getStudent_name().length(), b.getStudent_name().length()); i++) {
                    if (a.getStudent_name().charAt(i) - b.getStudent_name().charAt(i) < 0)
                        return 1;
                    else
                        return -1;
                }
                if (a.getStudent_name().length() < b.getStudent_name().length())
                    return 1;

                if (a.getStudent_code() - b.getStudent_code() < 0)
                    return 1;

                return -1;
            }
        });
        print();
    }

    public static void sort_rank_required() {
        arrayList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if (a.getRequired_lesson().getGrade() - b.getRequired_lesson().getGrade() < 0)
                    return 1;
                else
                    return -1;
            }
        });
        print();
    }

    public static void sort_rank_optional() {
        arrayList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if (a.getOptional_lesson().getGrade() - b.getOptional_lesson().getGrade() < 0)
                    return 1;
                else
                    return -1;
            }
        });
        print();
    }

    public static void sort_rank_goal() {
        arrayList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if (a.getTotal_goal() - b.getTotal_goal() < 0)
                    return 1;
                else
                    return -1;
            }
        });
        print();
    }

    public static void sort_rank_experimental() {
        arrayList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if (a.getExperimental_lesson().getGrade() - b.getExperimental_lesson().getGrade() < 0)
                    return 1;
                else
                    return -1;
            }
        });
        print();
    }

    public static void print() {
        System.out.println("现在的成绩表是 : ");
        System.out.println("学号\t姓名\t" + required_subject_name + "\t" + optional_subject_name + "\t"
                + experimental_subject_name + "\t" + "综合评分\t");
        for (Student it : arrayList) {
            it.print();
        }
    }

    public static void find_by_name() {
        System.out.print("想要查询的姓名是 : ");
        String op = new Scanner(System.in).next();
        boolean flag = false;
        System.out.println("学号\t姓名\t" + required_subject_name + "\t" + optional_subject_name + "\t"
                + experimental_subject_name + "\t" + "综合评分\t");
        for (Student it : arrayList) {
            if (it.getStudent_name().equals(op)) {
                flag = true;
                it.print();
            }
        }
        if (!flag)
            System.out.println("未找到学生");
    }

    public static void find_by_code() {
        boolean flag = false;
        System.out.print("想要查询的学号是 : ");
        int op = new Scanner(System.in).nextInt();
        System.out.println("学号\t姓名\t" + required_subject_name + "\t" + optional_subject_name + "\t"
                + experimental_subject_name + "\t" + "综合评分\t");

        for (Student it : arrayList) {
            if (op == it.getStudent_code()) {
                flag = true;
                it.print();
            }
        }
        if (!flag)
            System.out.println("未找到学生");
    }

    public static void find_by_goal() {
        boolean flag = false;
        System.out.print("想要查询的范围是 : ");
        Scanner sc = new Scanner(System.in);
        int upper = sc.nextInt(), lower = sc.nextInt();
        System.out.println("学号\t姓名\t" + required_subject_name + "\t" + optional_subject_name + "\t"
                + experimental_subject_name + "\t" + "综合评分\t");
        for (Student it : arrayList) {
            double comp = it.getTotal_goal();
            if (comp <= lower && comp >= upper) {
                flag = true;
                it.print();
            }
        }
        if (!flag)
            System.out.println("未找到学生");
    }

    public static void find_by_required() {
        boolean flag = false;
        System.out.print("想要查询的范围是 : ");
        Scanner sc = new Scanner(System.in);
        int upper = sc.nextInt(), lower = sc.nextInt();
        System.out.println("学号\t姓名\t" + required_subject_name + "\t" + optional_subject_name + "\t"
                + experimental_subject_name + "\t" + "综合评分\t");
        for (Student it : arrayList) {
            int comp = it.getRequired_lesson().getGrade();
            if (comp <= lower && comp >= upper) {
                flag = true;
                it.print();
            }
        }
        if (!flag)
            System.out.println("未找到学生");
    }

    public static void find_by_optional() {
        boolean flag = false;
        System.out.print("想要查询的范围是 : ");
        Scanner sc = new Scanner(System.in);
        int upper = sc.nextInt(), lower = sc.nextInt();
        System.out.println("学号\t姓名\t" + required_subject_name + "\t" + optional_subject_name + "\t"
                + experimental_subject_name + "\t" + "综合评分\t");
        for (Student it : arrayList) {
            int comp = it.getOptional_lesson().getGrade();
            if (comp <= lower && comp >= upper) {
                flag = true;
                it.print();
            }
        }
        if (!flag)
            System.out.println("未找到学生");
    }

    public static void find_by_experimental() {
        boolean flag = false;
        System.out.print("想要查询的范围是 : ");
        Scanner sc = new Scanner(System.in);
        int upper = sc.nextInt(), lower = sc.nextInt();
        System.out.println("学号\t姓名\t" + required_subject_name + "\t" + optional_subject_name + "\t"
                + experimental_subject_name + "\t" + "综合评分\t");
        for (Student it : arrayList) {
            int comp = it.getExperimental_lesson().getGrade();
            if (comp <= lower && comp >= upper) {
                flag = true;
                it.print();
            }
        }
        if (!flag)
            System.out.println("未找到学生");
    }

    public static void find_by_grade() {
        System.out.print("想要查询的科目是 : ");
        String op = new Scanner(System.in).next();
        if (op.equals(required_subject_name))
            find_by_required();
        else if (op.equals(optional_subject_name))
            find_by_optional();
        else if (op.equals(experimental_subject_name))
            find_by_experimental();
        else {
            System.out.println("输入无效 ， 请重新输入");
            find_by_grade();
        }
    }

    public static void find() {
        arrayList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if (a.getStudent_code() - b.getStudent_code() > 0)
                    return 1;
                else
                    return -1;
            }
        });
        System.out.print("查找内容(姓名、学号、综合评分、单科成绩)");
        Scanner sc = new Scanner(System.in);
        String op = sc.next();
        if (op.equals("姓名"))
            find_by_name();
        else if (op.equals("学号"))
            find_by_code();
        else if (op.equals("综合评分"))
            find_by_goal();
        else if (op.equals("单科成绩"))
            find_by_grade();
        else {
            System.out.println("无效输入，请重新输入");
            find();
        }
    }

    public static void _delete_by_code() {
        System.out.print("请输入想删除的学号 : ");
        int re = -1;
        int idx = new Scanner(System.in).nextInt();
        for (Student it : arrayList) {
            if (it.getStudent_code() == idx) {
                re = arrayList.indexOf(it);
            }
        }
        if (re != -1)
            arrayList.remove(re);
        print();
    }

    public static void _delete_by_name() {
        ArrayList<Integer> idx = new ArrayList<Integer>();
        System.out.print("想要删除的学生姓名是 : ");
        String op = new Scanner(System.in).next();
        for (Student it : arrayList) {
            if (it.getStudent_name().equals(op)) {
                idx.add(arrayList.indexOf(it));
            }
        }
        for (int it : idx) {
            arrayList.remove(it);
        }
        print();
    }

    public static void _delete() {
        arrayList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if (a.getStudent_code() - b.getStudent_code() > 0)
                    return 1;
                else
                    return -1;
            }
        });
        System.out.print("删除内容(姓名、学号)");
        Scanner sc = new Scanner(System.in);
        String op = sc.next();
        if (op.equals("姓名"))
            _delete_by_name();
        else if (op.equals("学号"))
            _delete_by_code();
        else {
            System.out.println("无效输入，请重新输入");
            _delete();
        }
    }

    public static void main(String[] args) throws Exception {

        init();
        print();
        while (true) {
            System.out.println("选择以下操作 : ");
            System.out.println("1.排序 ");
            System.out.println("2.查找");
            System.out.println("3.添加");
            System.out.println("4.删除");
            System.out.println("5.退出");
            int op;
            Scanner sc = new Scanner(System.in);
            try {
                op = sc.nextInt();
                if (op == 1)
                    sort_the_form();
                else if (op == 2)
                    find();
                else if (op == 3)
                    add();
                else if (op == 4)
                    _delete();
                else if (op == 5)
                    break;
                else {
                    System.out.println("无效输入，请重新输入");
                }
            } catch (InputMismatchException e) {
                System.out.println("无效操作，请重新操作");
            }
        }
        System.out.println("感谢使用");
    }
}

import java.util.*;

public class Main {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Nhập ");
            System.out.println("2. Hiển thị tất cả sinh viên nhập");
            System.out.println("3. Bắt đầu tuyển dụng ");
            System.out.println("4. Thoát");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    showAllStudent();
                    break;
                case 3:
                    System.out.println("Nhập số lượng người cần tuyển (11-15 người) :");
                    int requirementNumber = sc.nextInt();
                    sc.nextLine();
                    recuitStudents(students, requirementNumber).forEach(Student::ShowMyInfor);
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void addStudent(Scanner sc) {
        try {
            System.out.println("1, Good Student");
            System.out.println("2. Normal Student");
            int a = sc.nextInt();
            sc.nextLine();

            System.out.println("Nhập tên (gồm 10-50 kí tự)  ");
            String fullName = sc.nextLine();
            ValidateInput.validateFullName(fullName);

            System.out.println("Nhập ngày sinh (dd/MM/yyyy)  ");
            String doB = sc.nextLine();
            ValidateInput.validateDoB(doB);

            System.out.println("Nhập giới tính:");
            String sex = sc.nextLine();

            System.out.println("Nhập số điện thoại (bắt đầu bằng 090, 098, 091, 031, 035 hoặc 038 và có 10 cs ");
            String phoneNumber = sc.nextLine();
            ValidateInput.validatePhone(phoneNumber);

            System.out.println("Nhập tên trường đại học: ");
            String universityName = sc.nextLine();

            System.out.println("Nhập xếp loại tốt nghiệp: ");
            String gradeLevel = sc.nextLine();

            Student student;
            switch (a) {
                case 1:
                    System.out.println("Nhập điểm TBM: ");
                    double  gpa = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Nhập giải cao nhất từng dành được: ");
                    String bestRewardName = sc.nextLine();
                    student = new GoodStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel, gpa, bestRewardName, true);
                    break;
                case 2:
                    System.out.println("Nhập điểm TOEIC: ");
                    double englishScore = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Nhập điểm đầu vào: ");
                    double entryTestScore = sc.nextDouble();
                    sc.nextLine();
                    student = new NormalStudent(fullName, doB, sex, phoneNumber, universityName, gradeLevel,englishScore, entryTestScore, false);
                    break;
                default:
                    System.out.println("Nhập không hợp lệ ");
                    return;
            }
            students.add(student);
            System.out.println("Đã thêm 01 sinh viên vào hệ thống");
        }
        catch (FullNameException | DoBException | PhoneException e ) {
            System.out.println(e.getMessage());
        }

    }

    public static List<Student> recuitStudents(List<Student> students, int requirementNumber) {
        List<Student> recuitStudents = new ArrayList<>();
        //tạo list GS
        List<GoodStudent> goodStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.isGood()) {
                goodStudents.add((GoodStudent) student);
            }
        }
        //Sắp xếp
        goodStudents.sort(Comparator.comparing(GoodStudent::getGpa).reversed().thenComparing(GoodStudent::getFullName));
        //Nhập sv từ list GS sang List S
        for (Student student : goodStudents) {
            if (recuitStudents.size() < requirementNumber) {
                recuitStudents.add(student);
            } else {
                break;
            }
        }
        //nếu chưa đủ thì tạo thêm List NS
        if (recuitStudents.size() < requirementNumber) {
            List<NormalStudent> normalStudents = new ArrayList<>();
            for (Student student : students) {
                if (!student.isGood()) {
                    normalStudents.add((NormalStudent) student);
                }
            }
            //sắp xếp NS
            normalStudents.sort(Comparator.comparing(NormalStudent::getEntryTestScore).reversed().thenComparing(NormalStudent::getEnglishScore).reversed().thenComparing(NormalStudent::getFullName));
            for (Student student : normalStudents) {
                if (recuitStudents.size() < requirementNumber) {
                    recuitStudents.add(student);
                } else {
                    break;
                }
            }
        }
        return recuitStudents;
    }

    public static void showAllStudent() {
        students.sort(Comparator.comparing(Student::getFullName).thenComparing(Student::getPhoneNumber).reversed());
        for (Student student : students) {
            student.ShowMyInfor();
        }
    }
}
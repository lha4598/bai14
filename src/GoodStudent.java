import java.util.Scanner;

public class GoodStudent extends Student {
    private double gpa;
    private String bestRewardName;


    public GoodStudent() {
        super();
    }

    public GoodStudent(String fullName, String doB, String sex, String phoneNumber, String universityName, String gradeLevel, double gpa, String bestRewardName, boolean isGood) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel, isGood);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }



    @Override
    public void ShowMyInfor() {
        System.out.println(this.fullName+": " + this.doB + " // " + this.sex + " // " + this.phoneNumber + " // " + this.universityName + " // " + this.gradeLevel + " // " + this.gpa + " // " + this.bestRewardName);
    }
}

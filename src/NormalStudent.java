import java.util.Scanner;

public class NormalStudent extends Student{
    private double englishScore;
    private double entryTestScore;

    public NormalStudent() {
        super();
    }

    public NormalStudent(String fullName, String doB, String sex, String phoneNumber, String universityName, String gradeLevel, double englishScore, double entryTestScore, boolean isGood) {
        super(fullName, doB, sex, phoneNumber, universityName, gradeLevel, isGood);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }



    @Override
    public void ShowMyInfor() {
        System.out.println(this.fullName+ ": " + this.doB + " // " + this.sex + " // " + this.phoneNumber + " // " + this.universityName + " // " + this.gradeLevel + " // " +this.englishScore + " // " + this.entryTestScore);
    }
}

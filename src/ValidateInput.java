import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidateInput {
    public static void validateFullName(String fullName) throws FullNameException {
        String fullNameRegex = "^[a-zA-Z\\s]{10,50}$";
        if (!fullName.matches(fullNameRegex)) {
            throw new FullNameException("Tên chỉ gồm chữ cái và từ 10-50 kí tự");
        }
    }
    public static void validateDoB(String doB) throws DoBException {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate date = LocalDate.parse(doB, dateFormatter);
            if (date.isAfter(LocalDate.now())) {
                throw new DoBException("Ngày sinh nhập sai vui lòng nhập lại.");
            }
        } catch (DateTimeParseException e) {
            throw new DoBException("Sai định dạng ngày sinh dd/MM/yyyy.");
        }
    }

    public static void validatePhone(String phone) throws PhoneException {
        String phoneRegex = "^(090|098|091|031|035|038)\\d{7}$";
        if (!phone.matches(phoneRegex)) {
            throw new PhoneException("Số điện thoại phải có 10 chữ số và bắt đầu bằng 090, 098, 091, 031, 035, 038");
        }
    }

}

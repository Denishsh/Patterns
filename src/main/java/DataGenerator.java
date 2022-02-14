import com.github.javafaker.Faker;
import lombok.Data;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@UtilityClass
public class DataGenerator {

    @UtilityClass
    public static class Registration {
        public static RegistrationInfo generateInfo(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationInfo(
                    "Москва",
                    generateDate(3),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
        }
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Data
    class RegistrationInfo {
        private final String city;
        private final String date;
        private final String fullName;
        private final String phoneNumber;
    }
}

import static java.util.Objects.requireNonNull;

public class Email {

    private static final String MAIL_DOMAIN = "gmail.com";

    private final String email;

    public Email(String email) {
        requireNonNull(email, "Email not provided");
        checkDomain(email);
        this.email = email;
    }

    public static Email of(final String email) {
        return new Email(email);
    }

    private void checkDomain(String email) {
        if (!email.endsWith(MAIL_DOMAIN)) {
            throw new WrongEmailDomainException(email);
        }
    }
}
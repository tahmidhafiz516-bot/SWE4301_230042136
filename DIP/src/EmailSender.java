public class EmailSender implements EmailService {

    @Override
    public void send(Email email) {
        System.out.println(
                "To: " + email.getTo()
                        + ", Subject: " + email.getSubject()
                        + ", Message: " + email.getMessage()
        );
    }
}
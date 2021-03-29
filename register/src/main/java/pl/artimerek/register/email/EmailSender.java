package pl.artimerek.register.email;

public interface EmailSender {
    void send(String to, String email);
}

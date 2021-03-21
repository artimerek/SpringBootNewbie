package pl.artimerek.register.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.artimerek.register.appuser.AppUser;
import pl.artimerek.register.appuser.AppUserRole;
import pl.artimerek.register.appuser.AppUserService;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }

        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}

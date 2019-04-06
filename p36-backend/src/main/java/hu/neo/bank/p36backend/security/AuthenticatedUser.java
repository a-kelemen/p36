package hu.neo.bank.p36backend.security;

import hu.neo.bank.p36backend.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUser {

    private User user;

}

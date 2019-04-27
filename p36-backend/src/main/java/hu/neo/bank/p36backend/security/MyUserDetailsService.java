package hu.neo.bank.p36backend.security;

import hu.neo.bank.p36backend.model.User;
import hu.neo.bank.p36backend.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepositoryInterface userRepository;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    //now: username = firstname
    @Override
    public UserDetails loadUserByUsername(String firstname) throws UsernameNotFoundException {
        User optionalUser = userRepository.findUserByFirstname(firstname);

        if (optionalUser == null) {
            throw new UsernameNotFoundException(firstname);
        }

        User user = optionalUser;

        authenticatedUser.setUser(user);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}

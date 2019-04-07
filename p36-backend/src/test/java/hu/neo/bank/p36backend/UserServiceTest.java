package hu.neo.bank.p36backend;

import hu.neo.bank.p36backend.model.User;
import hu.neo.bank.p36backend.repository.UserRepositoryInterface;
import hu.neo.bank.p36backend.service.UserService;
import hu.neo.bank.p36backend.service.UserServiceInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

//@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepositoryInterface mockUserRepository;

    @Mock
    private BCryptPasswordEncoder mockPasswordEncoder;

    @Autowired
    private UserService userServiceUnderTest;

    //@Autowired
    private User user;

    @Before
    public void setUp() {
        initMocks(this);

        user = User.builder()
                .id(2)
                .firstname("Tom")
                .lastname("Denem")
                .username("voldemort")
                .password("pureblood")
                .email("adava@kedavra.com")
                .role(User.Role.ROLE_USER).build();
        //System.out.println(user.toString()); //nullpointer exception

        Mockito.when(mockUserRepository.findByUsername(anyString())).thenReturn(user);
    }

    @Test
    public void testFindByUsername() {
        final String name = "voldemort";
        //System.out.println(mockUserRepository.findByUsername(name).getUsername()); //voldemort
        //System.out.println(userServiceUnderTest.findByUsername(name));
        final User result = mockUserRepository.findByUsername(name);
        assertEquals(name, result.getUsername());
    }

    @Test
    public void testCreateUser() {

    }

}

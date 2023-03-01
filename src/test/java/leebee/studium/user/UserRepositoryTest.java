package leebee.studium.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserRepositoryTest {
    private UserRepository userRepository = new MemoryUserRepository();

    @DisplayName("User 객체를 저장한다.")
    @Test
    void save() {
        User user = new User(1L, "사용자1");

        userRepository.save(user);
        User findUser = userRepository.findById(1L);

        assertThat(findUser.getName()).isEqualTo(user.getName());
    }

    @DisplayName("모든 User 객체를 반환한다.")
    @Test
    void findAll() {
        User user1 = new User(1L, "사용자1");
        User user2 = new User(2L, "사용자2");
        User user3 = new User(3L, "사용자3");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        List<User> users = userRepository.findAll();

        assertThat(users).contains(user1, user2, user3);
    }
}
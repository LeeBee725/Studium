package leebee.studium.user;

import java.util.List;

public interface UserRepository {
    /**
     * User 객체를 저장한다.
     *
     * @param user 저장할 User 객체
     * @throws NullPointerException user가 null일 경우 예외를 던진다.
     */
    void save(User user) throws NullPointerException;

    /**
     * 저장된 객체들 중 고유식별번호가 id User 객체를 반환한다.
     *
     * @param id 찾을 User의 고유식별번호
     * @return 고유식별번호가 id인 User 객체
     * @throws IllegalArgumentException 저장된 객체중 id 값을 갖는 User 객체가 없다면 예외를 던진다.
     */
    User findById(Long id) throws IllegalArgumentException;

    /**
     * 저장된 모든 User 객체를 반환한다.
     *
     * @return 저장된 모든 User 객체
     */
    List<User> findAll();
}

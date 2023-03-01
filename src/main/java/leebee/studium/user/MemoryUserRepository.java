package leebee.studium.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryUserRepository implements UserRepository{
    private final Map<Long, User> map = new HashMap<>();

    @Override
    public void save(User user) throws NullPointerException{
         if (user == null) {
             throw new NullPointerException();
         }
         map.put(user.getId(), user);
    }

    @Override
    public User findById(Long id) throws IllegalArgumentException{
        if (!map.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        return map.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(map.values());
    }
}

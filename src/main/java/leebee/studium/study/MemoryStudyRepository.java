package leebee.studium.study;

import java.util.*;

public class MemoryStudyRepository implements StudyRepository{
    private final Map<Long, Study> map = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public void save(Study study) {
        if (study == null) {
            throw new NullPointerException("MemoryStudyRepository::save=>Study 객체가 null 입니다.");
        }
        study.setId(++sequence);
        map.put(study.getId(), study);
    }

    @Override
    public Study findById(Long id) {
        if (!map.containsKey(id)) {
            throw new NoSuchElementException("MemoryStudyRepository::findById=>Id가 " + id + "인 값이 없습니다.");
        }
        return map.get(id);
    }

    @Override
    public List<Study> findAll() {
        return new ArrayList<>(map.values());
    }
}

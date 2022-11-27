package golmu.studium.study;

import java.util.HashMap;
import java.util.Map;

public class MemoryStudyRepository implements StudyRepository{
    private final Map<Long, Study> map = new HashMap<>();

    @Override
    public void save(Study study) {
        if (study == null) {
            System.out.println("MemoryStudyRepository::save=>Study 객체가 null 입니다.");
            return ;
        }
        map.put(study.getId(), study);
    }

    @Override
    public Study findById(Long id) {
        if (!map.containsKey(id)) {
            System.out.printf("MemoryStudyRepository::findById=>Id가 %d인 값이 없습니다.", id);
        }
        return map.get(id);
    }
}
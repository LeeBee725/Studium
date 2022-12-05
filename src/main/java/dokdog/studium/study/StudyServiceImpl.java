package golmu.studium.study;

import java.util.List;

public class StudyServiceImpl implements StudyService {
    private final StudyRepository studyRepository = new MemoryStudyRepository();
    private static Long sequence = 0L;

    @Override
    public StudyDto open(StudyDto form) {
        Study study = new Study(++sequence, form.getSubject());
        studyRepository.save(study);
        return study;
    }

    @Override
    public List<StudyDto> searchTotalStudy() {
        return studyRepository.findAll();
    }
}

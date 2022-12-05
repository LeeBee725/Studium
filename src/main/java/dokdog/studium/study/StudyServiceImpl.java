package dokdog.studium.study;

import dokdog.studium.utils.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class StudyServiceImpl implements StudyService {
    private final StudyRepository studyRepository = new MemoryStudyRepository();
    private final Mapper mapper = new StudyMapper();

    @Override
    public void open(StudyDto form) {
        studyRepository.save((Study) mapper.dtoToDomain(form));
    }

    @Override
    public List<StudyDto> searchTotalStudy() {
        return studyRepository.findAll().stream()
                .map((e)->{return (StudyDto) mapper.domainToDto(e);})
                .collect(Collectors.toList());
    }
}

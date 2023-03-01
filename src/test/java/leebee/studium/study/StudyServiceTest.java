package leebee.studium.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class StudyServiceTest {
    private final StudyService studyService = new StudyServiceImpl();

    @DisplayName("스터디를 개설한다.")
    @Test
    void open() {
        StudyDto studyDTO = new StudyDto("주제1");

        studyService.open(studyDTO);
        List<StudyDto> studies = studyService.searchTotalStudy();

        Assertions.assertThat(studies.get(0).getSubject()).isEqualTo(studyDTO.getSubject());
    }
}
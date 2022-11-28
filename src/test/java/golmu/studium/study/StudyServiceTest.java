package golmu.studium.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudyServiceTest {
    private final StudyService studyService = new StudyServiceImpl();

    @DisplayName("스터디를 개설한다.")
    @Test
    void open() {
        StudyDTO studyDTO = new StudyDTO("주제1");

        studyService.open(studyDTO);
        List<Study> studies = studyService.searchTotalStudy();

        Assertions.assertThat(studies.get(0).getSubject()).isEqualTo(studyDTO.getSubject());
    }
}
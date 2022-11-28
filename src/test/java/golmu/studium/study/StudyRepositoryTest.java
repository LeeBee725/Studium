package golmu.studium.study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudyRepositoryTest {
    private final MemoryStudyRepository studyRepository = new MemoryStudyRepository();

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void beforeEach() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void afterEach() {
        System.setOut(standardOut);
        System.out.println(captor);
    }

    @DisplayName("저장할 Study 객체의 id는 저장후 찾은 Study 객체의 id와 같다.")
    @Test
    void save() {
        Study study = new Study(1L, "주제1");

        studyRepository.save(study);
        Study findStudy = studyRepository.findById(1L);

        assertThat(study.getId()).isEqualTo(findStudy.getId());
    }

    @DisplayName("null 을 저장하려 하면 표준출력으로 저장하려는 객체가 null 임을 표시한다.")
    @Test
    void saveNull() {
        Study study = null;

        studyRepository.save(study);

        assertThat(output()).contains("StudyRepository::save=>Study 객체가 null 입니다.");
    }

    @DisplayName("없는 id의 Study를 검색하면 표준출력으로 없음을 표시한다.")
    @Test
    void findById() {
        Study study = new Study(1L, "주제1");

        studyRepository.save(study);
        studyRepository.findById(2L);

        assertThat(output()).contains("StudyRepository::findById=>Id가 2인 값이 없습니다.");
    }

    @DisplayName("저장된 모든 Study 객체를 조회한다.")
    @Test
    void findAll() {
        Study study1 = new Study(1L, "주제1");
        Study study2 = new Study(2L, "주제2");
        Study study3 = new Study(3L, "주제3");

        studyRepository.save(study1);
        studyRepository.save(study2);
        studyRepository.save(study3);
        List<Study> studies = studyRepository.findAll();

        assertThat(studies).contains(study1, study2, study3);
    }

    private String output() {
        return captor.toString().trim();
    }
}
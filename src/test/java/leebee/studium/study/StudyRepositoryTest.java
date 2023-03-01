package leebee.studium.study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StudyRepositoryTest {
    private final StudyRepository studyRepository = new MemoryStudyRepository();

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
        Study study = new Study();

        study.setSubject("주제1");
        studyRepository.save(study);
        Study findStudy = studyRepository.findById(study.getId());

        assertThat(study.getId()).isEqualTo(findStudy.getId());
    }

    @DisplayName("null 을 저장하려 하면 예외가 발생한다.")
    @Test
    void saveNull() {
        Study study = null;

       assertThatThrownBy(()->{
            studyRepository.save(study);
        }).isInstanceOf(NullPointerException.class);
    }

    @DisplayName("null 을 저장하려 하면 예외가 발생하며 예외 메시지는 다음과 같다.")
    @Test
    void saveNullMsg() {
        Study study = null;

        try {
            studyRepository.save(study);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        assertThat(output()).contains("StudyRepository::save=>Study 객체가 null 입니다.");
    }

    @DisplayName("없는 id의 Study를 검색하면 예외가 발생한다.")
    @Test
    void findByIdNoSuchElement() {
        Study study = new Study();

        study.setSubject("주제1");
        assertThatThrownBy(() -> {
            studyRepository.save(study);
            studyRepository.findById(study.getId() + 1);
        }).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("없는 id의 Study를 검색하면 예외가 발생하며 메시지는 다음과 같다.")
    @Test
    void findByIdNoSuchElementMsg() {
        Study study = new Study(1L, "주제1");

        try {
            studyRepository.save(study);
            studyRepository.findById(2L);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

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

        Assertions.assertThat(studies).contains(study1, study2, study3);
    }

    private String output() {
        return captor.toString().trim();
    }
}
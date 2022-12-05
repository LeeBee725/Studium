package dokdog.studium.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StudyMapperTest {
    private final StudyMapper studyMapper = new StudyMapper();

    @DisplayName("StudyDto를 Study로 바꾼다.")
    @Test
    void dtoToDomain() {
        StudyDto studyDto = new StudyDto("주제1");

        Study domain = (Study) studyMapper.dtoToDomain(studyDto);

        assertThat(domain.getSubject()).isEqualTo(studyDto.getSubject());
    }

    @DisplayName("StudyDto가 아니면 예외가 발생한다.")
    @Test
    void dtoToDomainNotStudyDto() {
        Object obj = new Object();

        assertThatThrownBy(() -> studyMapper.dtoToDomain(obj)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Study를 StudyDto로 바꾼다.")
    @Test
    void domainToDto() {
        Study study = new Study(1L, "주제1");

        StudyDto dto = (StudyDto) studyMapper.domainToDto(study);

        assertThat(dto.getSubject()).isEqualTo(study.getSubject());
    }

    @DisplayName("Study가 아니면 예외가 발생한다.")
    @Test
    void domainToDtoNotStudy() {
        Object obj = new Object();

        assertThatThrownBy(()->studyMapper.domainToDto(obj)).isInstanceOf(IllegalArgumentException.class);
    }
}

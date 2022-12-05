package dokdog.studium.study;

import java.util.List;

public interface StudyRepository {
    /**
     * Study에 대한 정보를 받아 저장한다.
     *
     * @param study Study 정보
     */
    void save(Study study);

    /**
     * 고유식별번호를 이용하여 Study를 찾는다.
     *
     * @param id 고유식별번호
     * @return 찾은 Study 객체를 반환한다.
     */
    Study findById(Long id);

    /**
     * 모든 Study 객체를 반환한다.
     *
     * @return 모든 Study 객체
     */
    List<Study> findAll();
}

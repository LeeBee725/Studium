package golmu.studium.study;

import java.util.List;

public interface StudyService {
    /**
     * 스터디를 개설한다.
     *
     * @param form 스터디를 생성하기 위한 정보를 갖고 있는 객체
     * @return 개설된 스터디
     */
    Study open(StudyDTO form);

    /**
     * 개설된 모든 스터디를 반환한다.
     * 
     * @return 개설된 스터디들
     */
    List<Study> searchTotalStudy();
}

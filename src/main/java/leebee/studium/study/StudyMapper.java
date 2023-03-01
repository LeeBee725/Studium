package leebee.studium.study;

import leebee.studium.utils.Mapper;

public class StudyMapper implements Mapper {
    @Override
    public Object dtoToDomain(Object dto) {
        if (!(dto instanceof StudyDto)) {
            throw new IllegalArgumentException("StudyMapper::dtoToDomain()=>StudyDto가 아닙니다.");
        }
        Study study = new Study();
        study.setSubject(((StudyDto) dto).getSubject());
        return study;
    }

    @Override
    public Object domainToDto(Object domain) {
        if (!(domain instanceof Study)) {
            throw new IllegalArgumentException("StudyMapper::domainToDto()=>Study가 아닙니다.");
        }
        return new StudyDto(((Study) domain).getSubject());
    }
}

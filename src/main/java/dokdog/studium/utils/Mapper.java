package dokdog.studium.utils;

public interface Mapper {
    /**
     * DTO를 받아서 도메인 객체를 반환한다.
     *
     * @param dto DTO
     * @return 도메인 객체
     */
    Object dtoToDomain(Object dto);

    /**
     * 도메인 객체를 받아서 DTO를 반환한다.
     *
     * @param domain
     * @return DTO
     */
    Object domainToDto(Object domain);
}

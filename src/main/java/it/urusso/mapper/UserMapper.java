package it.urusso.mapper;

import it.urusso.model.dto.UserDto;
import it.urusso.model.entity.UserDao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    UserDto toDto(UserDao dao);
    UserDao toEntity(UserDto dto);
}

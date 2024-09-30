package it.urusso.service;

import io.quarkus.runtime.util.StringUtil;
import it.urusso.exception.BusinessException;
import it.urusso.exception.ErrorMessage;
import it.urusso.mapper.UserMapper;
import it.urusso.model.dto.UserDto;
import it.urusso.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto findById(Long id) {
        var dao = userRepository.findById(id);
        return userMapper.toDto(dao);
    }

    public UserDto findByFiscalCode(String fiscalCode) {
        var dao = userRepository.findByFiscalCode(fiscalCode);
        return userMapper.toDto(dao);
    }

    @Transactional
    public UserDto createUser(UserDto dto) {
        var dao = userMapper.toEntity(dto);
        userRepository.persist(dao);

        return userMapper.toDto(dao);
    }

    @Transactional
    public UserDto updateUser(UserDto dto) {
        if(dto.id() == null)
            throw new BusinessException(ErrorMessage.ID_NULL);

        var dao = userRepository.findById(dto.id());
        if(!StringUtil.isNullOrEmpty(dto.name()))
            dao.setName(dto.name());
        if(!StringUtil.isNullOrEmpty(dto.surname()))
            dao.setSurname(dto.surname());
        if(!StringUtil.isNullOrEmpty(dto.fiscalCode()))
            dao.setFiscalCode(dto.fiscalCode());

        userRepository.persist(dao);

        return userMapper.toDto(dao);
    }
}

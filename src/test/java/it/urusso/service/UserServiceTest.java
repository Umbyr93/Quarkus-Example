package it.urusso.service;

import it.urusso.BaseMockitoTest;
import it.urusso.exception.BusinessException;
import it.urusso.mapper.UserMapper;
import it.urusso.model.dto.UserDto;
import it.urusso.model.entity.UserDao;
import it.urusso.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class UserServiceTest extends BaseMockitoTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;

    @BeforeEach
    void init() {
        userService = new UserService(userRepository, userMapper);
    }

    @Test
    void findByIdTest() {
        var dto = new UserDto(1L, "a", "b", "c");
        when(userMapper.toDto(any())).thenReturn(dto);

        var res = userService.findById(1L);
        assertNotNull(res);
        assertEquals(dto, res);
    }

    @Test
    void findByFiscalCodeTest() {
        var dto = new UserDto(1L, "a", "b", "c");
        when(userMapper.toDto(any())).thenReturn(dto);

        var res = userService.findByFiscalCode("fc");
        assertNotNull(res);
        assertEquals(dto, res);
    }

    @Test
    void createUserTest() {
        var dto = new UserDto(1L, "a", "b", "c");
        when(userMapper.toDto(any())).thenReturn(dto);

        var res = userService.createUser(dto);
        assertNotNull(res);
        assertEquals(dto, res);
    }

    @Test
    void updateUserTest() {
        var dto = new UserDto(1L, "a", "b", "c");

        when(userMapper.toDto(any())).thenReturn(dto);
        when(userRepository.findById(anyLong())).thenReturn(new UserDao());

        var res = userService.updateUser(dto);
        assertNotNull(res);
        assertEquals(dto, res);
    }

    @Test
    void updateUserTest_IdNullException() {
        var dto = new UserDto(null, "a", "b", "c");
        assertThrows(BusinessException.class, () -> userService.updateUser(dto));
    }
}

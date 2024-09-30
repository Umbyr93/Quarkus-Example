package it.urusso.controller;

import it.urusso.model.dto.UserDto;
import it.urusso.service.UserService;
import jakarta.ws.rs.*;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

@Path("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GET
    @Path("{id}")
    public RestResponse<UserDto> getById(@RestPath Long id) {
        var dto = userService.findById(id);
        return RestResponse.ok(dto);
    }

    @GET
    public RestResponse<UserDto> getByFiscalCode(@QueryParam("fiscalCode") String fiscalCode) {
        var dto = userService.findByFiscalCode(fiscalCode);
        return RestResponse.ok(dto);
    }

    @POST
    public RestResponse<UserDto> createUser(UserDto input) {
        var dto = userService.createUser(input);
        return RestResponse.ok(dto);
    }

    @PATCH
    public RestResponse<UserDto> updateUser(UserDto input) {
        var dto = userService.updateUser(input);
        return RestResponse.ok(dto);
    }
}

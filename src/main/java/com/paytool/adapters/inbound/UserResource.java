package com.paytool.adapters.inbound;

import com.paytool.adapters.outbound.dto.UserDto;
import com.paytool.adapters.outbound.dto.UserResponseDto;
import com.paytool.adapters.outbound.entity.UserEntity;
import com.paytool.adapters.outbound.mapper.UserMapper;
import com.paytool.application.core.domain.models.User;
import com.paytool.application.core.service.UserService;
import com.paytool.application.ports.inbound.UserPort;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import java.util.List;
import java.util.UUID;

@Path("/users")
public class UserResource {

    @Inject
    private UserService userService;

    @GET
    public Response getUsers() {
        return Response.ok(
                UserMapper.INSTANCE.mapUserListToUserResponseDtoList(
                        userService.getUsers())
                    ).build();
    }

    @GET
    @Path("{id}")
    public Response getUserById(@PathParam("id") UUID id) {
        return Response.ok(
                UserMapper.INSTANCE.userToUserResponseDto(
                        userService.getUserById(id))
                        ).build();
    }

    @POST
    public Response saveUser(@RequestBody UserDto userDto) {
        return Response.ok(
                userService.saveUser(
                        UserMapper.INSTANCE.userDtoToUser(userDto))
                        ).build();
    }

    @DELETE
    @Path("{id}")
    public Response saveUser(@PathParam("id") UUID id) {
        userService.deleteUser(id);
        return Response.ok("Successfully deleted user").build();
    }


}

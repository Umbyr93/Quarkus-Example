package it.urusso.config;

import it.urusso.exception.BusinessException;
import it.urusso.exception.ErrorDto;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ErrorHandler implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable t) {
        if(t instanceof BusinessException) {
            return handleBusinessException((BusinessException) t);
        }

        return null; //handles the exception as usual
    }

    private static Response handleBusinessException(BusinessException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorDto(e.getCode(), e.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}

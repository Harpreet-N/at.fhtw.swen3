package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.ParcelApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-18T12:42:11.503113Z[Etc/UTC]")
@Controller
@Slf4j
public class ParcelApiController implements ParcelApi {

    private final NativeWebRequest request;

    @Autowired
    public ParcelApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}

package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.ParcelApi;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.exception.BLParcelException;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-18T12:42:11.503113Z[Etc/UTC]")
@Controller
@Slf4j
public class ParcelApiController implements ParcelApi {

    private final NativeWebRequest request;
    private final ParcelService parcelService;
    private final ParcelMapper parcelMapper = ParcelMapper.INSTANCE;

    @Autowired
    public ParcelApiController(NativeWebRequest request, ParcelServiceImpl parcelService) {
        this.request = request;
        this.parcelService = parcelService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Void> reportParcelDelivery(@Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId) throws BLParcelException {
        log.info("reportParcelDelivery called");
        parcelService.reportParcelDelivery(trackingId);
        log.info("Parcel delivery reported");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> reportParcelHop(@Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId, @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$") @Parameter(name = "code", description = "The Code of the hop (Warehouse or Truck).", required = true) @PathVariable("code") String code) throws BLParcelException {
        log.info("reportParcelHop called");
        parcelService.reportParcelHop(trackingId, code);
        log.info("Parcel hop reported");
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(@Parameter(name = "Parcel", description = "", required = true) @Valid @RequestBody Parcel parcel) throws BLParcelException {
        log.info("submitParcel called");
        ParcelEntity parcelEntity = parcelMapper.parcelDtoToEntity(parcel);
        parcelService.submitParcel(parcelEntity);
        NewParcelInfo newParcelInfo = parcelMapper.entityToNewParcelInfoDto(parcelEntity);
        log.info("New Parcel created");
        return new ResponseEntity<>(newParcelInfo, HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<TrackingInformation> trackParcel(@Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId) throws BLParcelException {
        log.info("trackParcel called");
        TrackingInformation trackingInformation = parcelMapper.entityToTrackingInformationDto(parcelService.trackParcel(trackingId));
        log.info("Parcel tracked");
        return new ResponseEntity<>(trackingInformation, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<NewParcelInfo> transitionParcel(@Pattern(regexp = "^[A-Z0-9]{9}$") @Parameter(name = "trackingId", description = "The tracking ID of the parcel. E.g. PYJRB4HZ6 ", required = true) @PathVariable("trackingId") String trackingId, @Parameter(name = "Parcel", description = "", required = true) @Valid @RequestBody Parcel parcel) throws BLParcelException {
        log.info("transitionParcel called");
        ParcelEntity parcelEntity = parcelMapper.parcelDtoToEntity(parcel);
        parcelService.transitionParcel(parcelEntity);
        NewParcelInfo newParcelInfo = parcelMapper.entityToNewParcelInfoDto(parcelEntity);
        log.info("Parcel transitioned");
        return new ResponseEntity<>(newParcelInfo, HttpStatus.CREATED);
    }

}

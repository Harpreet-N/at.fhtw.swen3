package at.fhtw.swen3.controller.rest;

import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import javax.validation.ValidationException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource("/application.properties")
class ParcelApiControllerTest {
    private final ParcelApiController parcelApiController;

    @Autowired
    ParcelApiControllerTest(ParcelApiController parcelApiController) {
        this.parcelApiController = parcelApiController;
    }

    @Test
    void testReportParcelDeliveryValid() {
        ResponseEntity<Void> response = parcelApiController.reportParcelDelivery("ABC123DEF");

        assertNotEquals(response, null);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    void testReportParcelDeliveryInvalid() {
        assertThrows(ValidationException.class, ()->{parcelApiController.reportParcelDelivery("A");});
    }

    @Test
    void testReportParcelHopValid() {
        ResponseEntity<Void> response = parcelApiController.reportParcelHop("ABC123DEF", "ABCD1234");

        assertNotEquals(response, null);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    void testReportParcelHopInvalid() {
        assertThrows(ValidationException.class, ()->{parcelApiController.reportParcelHop("ABC123DEF", "A");});
    }

    @Test
    void testSubmitParcelValid() {
        Parcel parcel = new Parcel().recipient(createDummyRecipient()).sender(createDummyRecipient()).weight(1.0f);

        ResponseEntity<NewParcelInfo> response = parcelApiController.submitParcel(parcel);

        assertNotEquals(response, null);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    //TODO: Change 201 TO 400 when Service gets implemented
    @Test
    void testSubmitParcelInvalid() {
        Parcel parcel = new Parcel().recipient(createDummyRecipient()).sender(createDummyRecipient()).weight(1.0f);

        ResponseEntity<NewParcelInfo> response = parcelApiController.submitParcel(parcel);

        assertNotEquals(response, null);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    void testTrackParcelValid() {
        ResponseEntity<TrackingInformation> response = parcelApiController.trackParcel("ABC123DEF");

        assertNotEquals(response, null);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


    @Test
    void testTrackParcelInvalid() {
        assertThrows(ValidationException.class, ()->{parcelApiController.trackParcel("A");});

    }

    @Test
    void testTransitionParcelValid() {
        Parcel parcel = new Parcel().recipient(createDummyRecipient()).sender(createDummyRecipient()).weight(1.0f);
        ResponseEntity<NewParcelInfo> response = parcelApiController.transitionParcel("ABC123DEF", parcel);

        assertNotEquals(response, null);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    void testTransitionParcelInvalid() {
        Parcel parcel = new Parcel().recipient(createDummyRecipient()).sender(createDummyRecipient()).weight(1.0f);
        assertThrows(ValidationException.class, ()->{parcelApiController.transitionParcel("A", parcel);});
    }

    Recipient createDummyRecipient() {
        return new Recipient().name("Name").city("Wien").country("Österreich").postalCode("A-1234").street("Ngasse 1");
    }
}
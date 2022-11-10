package at.fhtw.swen3.persistence.entities;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class ParcelEntity {


    private Float weight;

    private RecipientEntity recipient;


    private RecipientEntity sender;


    private String trackingId;


    private TrackingInformation.StateEnum state;


    private List<HopArrivalEntity> visitedHops = new ArrayList<>();


    private List<HopArrivalEntity> futureHops = new ArrayList<>();

}

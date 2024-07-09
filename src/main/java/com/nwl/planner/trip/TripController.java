package com.nwl.planner.trip;

import com.nwl.planner.participant.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private TripRpository repository;

    @PostMapping
    public ResponseEntity<String> createTrip(@RequestBody TripRequestPayLoad payLoad){
        Trip newTrip = new Trip(payLoad);

        this.repository.save(newTrip);
        this.participantService.registerParticipantesToEvent(payLoad.emails_to_invite(), newTrip.getId());

        return ResponseEntity.ok("Sucess!");

    }
}

package com.nwl.planner.trip;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TripRpository  extends JpaRepository<Trip, UUID> {
}

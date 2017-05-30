package de.hfu.meldeauskunft.repository;

import java.util.List;

import de.hfu.meldeauskunft.domain.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentRepository {

  List<Resident> getResidents();

}
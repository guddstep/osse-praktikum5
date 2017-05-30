package de.hfu.meldeauskunft.service;

import java.util.List;

import de.hfu.meldeauskunft.domain.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentService {

  Resident getUniqueResident(Resident filterResident) throws ResidentServiceException;

  List<Resident> getFilteredResidentsList(Resident filterResident);

}
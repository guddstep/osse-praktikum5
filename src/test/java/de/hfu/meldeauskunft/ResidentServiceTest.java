package de.hfu.meldeauskunft;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


import de.hfu.meldeauskunft.domain.Resident;
import de.hfu.meldeauskunft.repository.ResidentRepository;
import de.hfu.meldeauskunft.service.BaseResidentService;
import de.hfu.meldeauskunft.service.ResidentServiceException;

public class ResidentServiceTest {
	private static List<Resident> getTestResidents() {
		List<Resident> results = new LinkedList<Resident>();
		
		results.add(new Resident("Hans", "Meier", "Hauptstr. 1", "Freiburg", new Date(1993, 10, 10)));
		results.add(new Resident("Hanna", "Baumann", "Weg 10", "Brelin", new Date()));
		results.add(new Resident("Max", "Müller", "Dorftstr. 4", "Freiburg", new Date()));
		results.add(new Resident("Peter", "Fritz", "Hauptstr. 1", "Stuttgart", new Date()));
		
		return results;
	}
	
	private static BaseResidentService createTestResidentService() {
		ResidentRepository repositoryMock = createMock(ResidentRepository.class);
	    expect(repositoryMock.getResidents()).andReturn(getTestResidents());
	    
	    replay(repositoryMock);
		
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(repositoryMock);
		
		return service;
	}
	
	@Test
	public void getFilteredResidentsListTestFamilyName() {
		BaseResidentService service = createTestResidentService();
		
		List<Resident> residents = service.getFilteredResidentsList(new Resident("", "M*", "", "", null));
		
		assertEquals(2, residents.size());
		for (Resident r : residents)
			assertEquals('M', r.getFamilyName().charAt(0));
	}
	
	@Test
	public void getFilteredResidentsListTestCombined() {
		BaseResidentService service = createTestResidentService();
		
		List<Resident> residents = service.getFilteredResidentsList(new Resident("Hans", "", "", "Fr*", new Date(1993, 10, 10)));
		
		assertEquals(1, residents.size());
		for (Resident r : residents) {
			assertEquals("Hans", r.getGivenName());
			assertEquals("Freiburg", r.getCity());
		}
	}
	
	@Test
	public void getFilteredResidentsListTestAll() {
		BaseResidentService service = createTestResidentService();
		
		List<Resident> residents = service.getFilteredResidentsList(new Resident("", "", "", "", null));
		
		assertEquals(4, residents.size());
	}
	
	@Test
	public void getUniqueResidentTestGivenName() {
		BaseResidentService service = createTestResidentService();
		
		Resident filterResident = new Resident();
		filterResident.setGivenName("Hans");
		
		Resident resident = null;
		try {
			resident = service.getUniqueResident(filterResident);
		} catch (ResidentServiceException e) {
			fail();
		}
		
		assertNotNull(resident);
		assertEquals(filterResident.getGivenName(), resident.getGivenName());
	}
	
	@Test
	public void getUniqueResidentTestNoResult() {
		BaseResidentService service = createTestResidentService();
		
		Resident filterResident = new Resident();
		
		Resident resident = null;
		try {
			resident = service.getUniqueResident(filterResident);
			fail();
		} catch (ResidentServiceException e) {
			
		}
		
		assertNull(resident);
	}
	
	@Test
	public void getUniqueResidentTestWildcards() {
		BaseResidentService service = createTestResidentService();
		
		Resident filterResident = new Resident();
		filterResident.setFamilyName("M*");
		
		Resident resident = null;
		try {
			resident = service.getUniqueResident(filterResident);
			fail();
		} catch (ResidentServiceException e) {
			
		}
		
		assertNull(resident);
	}
}

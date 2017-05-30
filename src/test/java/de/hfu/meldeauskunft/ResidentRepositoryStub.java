package de.hfu.meldeauskunft;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import de.hfu.meldeauskunft.domain.Resident;
import de.hfu.meldeauskunft.repository.ResidentRepository;

public class ResidentRepositoryStub implements ResidentRepository {

	public List<Resident> getResidents() {
		List<Resident> results = new LinkedList<Resident>();
		
		results.add(new Resident("Hans", "Meier", "Hauptstr. 1", "Freiburg", new Date(1993, 10, 10)));
		results.add(new Resident("Hanna", "Baumann", "Weg 10", "Brelin", new Date()));
		results.add(new Resident("Max", "Müller", "Dorftstr. 4", "Freiburg", new Date()));
		results.add(new Resident("Peter", "Fritz", "Hauptstr. 1", "Stuttgart", new Date()));
		
		return results;
	}

}

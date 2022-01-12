package dev.mission.exec;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("listerProchainesMissions")
public class ListerProchainesMissions implements CommandLineRunner{
	
	private MissionRepository missionRepository;
	
	public MissionRepository listerProchainesMissions(MissionRepository missionRepository) {
		return this.missionRepository = missionRepository;
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		List<Mission> missions =  missionRepository.findByDateDebutAfter(LocalDate.now());
		missions.stream().map(Mission::getLibelle)
			.forEach(System.out::println);
	}
	

}

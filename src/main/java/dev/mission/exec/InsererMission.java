package dev.mission.exec;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

@Controller
@Profile("insert")
public class InsererMission implements CommandLineRunner {

	private MissionRepository missionRepository;

	public InsererMission(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}


	@Override
    public void run(String... args) throws Exception {
		Mission mission = new Mission();
		mission.setLibelle("Mission 3");
		mission.setTauxJournalier(new BigDecimal("1.11"));
		mission.setDateDebut(LocalDate.of(2020, 10, 5));
		mission.setDateFin(LocalDate.of(2020, 10, 10));

		this.missionRepository.save(mission);
	}
}


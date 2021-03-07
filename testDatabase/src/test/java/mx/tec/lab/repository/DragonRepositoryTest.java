package mx.tec.lab.repository;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mx.tec.lab.entity.Dragon;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DragonRepositoryTest {
	@Resource
	private DragonRepository dragonRepository;
	
	@Test
	public void givenDragon_whenSave_thenRetrieveSame() {
		Dragon dragon = new Dragon(1, "Meraxes");
		dragonRepository.save(dragon);
		
		Dragon retrievedDragon = dragonRepository.findById(1L).orElse(null);
		assertEquals("Meraxes", retrievedDragon.getName());
	}
	
	//3
	@Test
	public void givenDragon_whenSave_thenModifySame() {
		Dragon dragon = new Dragon(1, "Meraxes");
		dragonRepository.save(dragon);
		
		Dragon retrievedDragon = dragonRepository.findById(1L).orElse(null);
		retrievedDragon.setName("Balerion");
		dragonRepository.save(retrievedDragon);
		assertEquals("Balerion", retrievedDragon.getName());
	}

	//4
	@Test
	public void givenDragon_whenSave_thenDeleteSame() {
		Dragon dragon = new Dragon(1, "Meraxes");
		dragonRepository.save(dragon);
			
		dragonRepository.deleteById(1L);
		Dragon retrievedDragon = dragonRepository.findById(1L).orElse(null);
		assertNull(retrievedDragon, "No fue borrado");
	}
}

package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import spittr.Spitter;
import spittr.Spittle;
@Repository
public class MemorySpitterRepository implements SpitterRepository{
	List<Spitter> spitters = new ArrayList<>();
	
	@Override
	public Spitter save(Spitter spitter) {
		spitters.add(spitter);
		return null;
	}

	@Override
	public Spitter findByUsername(String username) {
		for(Spitter spitter:spitters){
			if(spitter.getUsername()!=null && spitter.getUsername().equals(username)){
				return spitter;
			}
		}
		return null;
	}
	
	
}

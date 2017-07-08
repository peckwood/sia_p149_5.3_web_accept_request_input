package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittleControllerMapping")
public class SpittleController {
	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpittleController(SpittleRepository spittleRepository){
		this.spittleRepository = spittleRepository;
	}
	
	//Query parameters
	@RequestMapping(method = RequestMethod.GET, value="/show")
	public String spittles(
			Model model, 
			@RequestParam(value="max", defaultValue="238900") long max,
			@RequestParam(value="count", defaultValue="20") int count){
		//add spittles to model
		/*When addAttribute() is called without specifying a key, the key is inferred from the type of 
		 * object being set as the value. In this case, because it��s a List<Spittle>, the key will be 
		 * inferred as spittleList
		 * */
		model.addAttribute(spittleRepository.findSpittles(max, count));
		//return view name
		return "spittles";
	}
	
	//Path variables
	@RequestMapping(method=RequestMethod.GET, value="/{spittleId}")
	public String showSpittle(@PathVariable("spittleId") long spittleId, Model model){
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}
	
	
	
}
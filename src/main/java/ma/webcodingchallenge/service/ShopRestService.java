package ma.webcodingchallenge.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.webcodingchallenge.dao.ShopRepository;
import ma.webcodingchallenge.dao.UserRepository;
import ma.webcodingchallenge.entities.Shop;
import ma.webcodingchallenge.entities.User;

@RestController
@RequestMapping("/shop")
public class ShopRestService {

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/all")
	public List<Shop> getShopsList() {
		return this.shopRepository.findAllByOrderByDistanceAsc();
	}
	
	@RequestMapping(value = "/preferredShops/{email}",method=RequestMethod.GET)
	public Set<Shop> getPreferredShopsList(@PathVariable("email") String email) {
		User user = this.userRepository.findByEmail(email);
		return user.getLikedShop();
		
	}
	

	@RequestMapping(value = "/addLikedShop/{email}", method = RequestMethod.POST)
	public User addNewPreferredShop(@PathVariable("email") String email, @RequestBody Shop shop) {

		User user = this.userRepository.findByEmail(email);
		Set<Shop> likedShop = user.getLikedShop();
		likedShop.add(shop);
		return this.userRepository.save(user);

	}

	@RequestMapping(value = "/removeLikedShop/{email}", method = RequestMethod.POST)
	public User removePreferredShop(@PathVariable("email") String email, @RequestBody Shop shop) {

		User user = this.userRepository.findByEmail(email);
		Set<Shop> likedShop = user.getLikedShop();

		Set<Shop> newlikedShop=new HashSet<>();
		newlikedShop=likedShop.stream().filter(s->s.getId()!=shop.getId()).collect(Collectors.toSet());		
		user.setLikedShop(newlikedShop);

		return this.userRepository.save(user);

	}

}

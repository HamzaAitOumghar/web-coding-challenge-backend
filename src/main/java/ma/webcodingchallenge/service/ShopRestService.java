package ma.webcodingchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.webcodingchallenge.dao.ShopRepository;
import ma.webcodingchallenge.entities.Shop;

@RestController
@RequestMapping("/shop")
public class ShopRestService {

	@Autowired
	private ShopRepository shopRepository;
	
	
	@RequestMapping(value="/all")
	public List<Shop> getShopsList(){
		return this.shopRepository.findAllByOrderByDistanceAsc();
	}
	
}

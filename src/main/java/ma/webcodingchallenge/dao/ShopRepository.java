package ma.webcodingchallenge.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.webcodingchallenge.entities.Shop;

public interface ShopRepository extends JpaRepository<Shop,Long> {

	List<Shop> findAllByOrderByDistanceAsc();
}

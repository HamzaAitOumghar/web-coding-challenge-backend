package ma.webcodingchallenge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.webcodingchallenge.entities.Shop;

public interface ShopRepository extends JpaRepository<Shop,Long> {

}

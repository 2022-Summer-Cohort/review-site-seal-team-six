package org.wecancoeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancoeit.reviews.model.Gym;

import java.util.Optional;

public interface GymRepository extends CrudRepository<Gym, Long> {
    Optional<Gym> findByName(String name);
    Optional<Gym> findByHashtag(String hashtag);



}

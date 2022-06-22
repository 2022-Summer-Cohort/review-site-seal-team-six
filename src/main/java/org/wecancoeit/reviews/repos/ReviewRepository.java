package org.wecancoeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancoeit.reviews.model.Review;

import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long>{
    Optional<Review>  findByTitle(String title);
    Optional<Review> findByUsername(String username);
    Optional<Review> findByHashtag(String hashtags);
}

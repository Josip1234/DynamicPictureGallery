package dynamic.picture.gallery.repository;

import org.springframework.data.repository.CrudRepository;

import dynamic.picture.gallery.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
User findByUsername(String username);
}

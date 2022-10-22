package am.itspace.bookstorage.service;

import am.itspace.bookstorage.entity.User;
import am.itspace.bookstorage.exception.DuplicateResourceException;
import am.itspace.bookstorage.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(User user) throws DuplicateResourceException {
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            throw  new DuplicateResourceException("User already exists!");
        }
        userRepository.save(user);
    }


}

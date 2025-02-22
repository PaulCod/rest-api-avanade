package dio.rest_api_avanade.domain.service.impl;

import dio.rest_api_avanade.domain.model.User;
import dio.rest_api_avanade.domain.repository.UserRepository;
import dio.rest_api_avanade.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccount_Number(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}

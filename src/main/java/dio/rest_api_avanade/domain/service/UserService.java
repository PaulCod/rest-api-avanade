package dio.rest_api_avanade.domain.service;

import dio.rest_api_avanade.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

}

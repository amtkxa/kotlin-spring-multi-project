package com.amtkxa.usecase.impl.fetchuser

import com.amtkxa.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class FetchUserUseCaseImpl(private val userRepository: UserRepository) : FetchUserUseCase {

    override fun execute(request: FetchUserRequest, response: FetchUserResponse) {
        val user = userRepository.findById(request.userId).orElseGet { null }
        response.setUser(user)
    }
}
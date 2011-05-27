package sdi.examples.module

import sdi.Context

trait UserService { def start() }

object UserService extends Context {
  define {
      bind[UserService] to new DefaultUserService scope singleton
      bind[UserRepository] to new DefaultUserRepository scope singleton
  }
}

import UserService.inject

class DefaultUserService(repository : UserRepository = inject[UserRepository]) extends UserService {
  println("DefaultUserService.constructor")

  def start() = {
    println("DefaultUserService.start")
    repository.start()
  }
}

trait UserRepository { def start() }

class DefaultUserRepository extends UserRepository{
  println("DefaultUserRepository.constructor")
  
  def start() = {
    println("DefaultUserRepository.start")
  }
}

class AdvancedUserRepository extends UserRepository{
  println("AdvancedUserRepository.constructor")

  def start() = {
    println("AdvancedUserRepository.start")
  }
}

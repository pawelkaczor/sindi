package sindi.examples.basic

import sindi._

/////////////////
// Application //
/////////////////

// [TODO] Replace scala.Application with scala.App when 2.8 support is dropped
//object Application extends App with Context with consumer.ConsumerComponent {
object Application extends scala.Application with Context with consumer.ConsumerComponent {
  import sindi.examples.basic.consumer.ConsumerModule

  override val modules = ConsumerModule(this) :: Nil

  override val bindings = bind[store.User].to(user) :: Nil

  private lazy val user = new store.User with store.RemoteStore

  consumer.start
}

/////////////////////
// Consumer Module //
/////////////////////

package consumer {
  import sindi.examples.basic.store._

  object ConsumerModule extends ModuleFactory[ConsumerModule]

  class ConsumerModule(implicit val context: Context) extends Module { 
    override val modules = StoreModule(this) :: Nil

    override val bindings = bind[Consumer].to(consumer) :: Nil

    private lazy val consumer = new ComponentContext(this) with Consumer
  }
  
  trait ConsumerComponent extends Component { lazy val consumer = from[ConsumerModule].inject[Consumer] }

  trait Consumer extends UserStore with UserPreferenceStore {
    def start() = {
      print("users: ")
      users.store()
      println("")

      print("userPreferences: ")
      userPreferences.store()
      println("")
    }
  }
}

//////////////////
// Store Module //
//////////////////

package store {
  object StoreModule extends ModuleFactory[StoreModule]

  class StoreModule(implicit context: Context) extends Module {
    override val bindings = bind[User].to(user) ::
                            bind[UserPreference].to(userPreferences) ::
                            Nil

    private lazy val user = new User with MemoryStore
    private lazy val userPreferences = new UserPreference with MemoryStore
  }

  trait UserStore extends Component { lazy val users = from[StoreModule].inject[User] }
  trait UserPreferenceStore extends Component { lazy val userPreferences = from[StoreModule].inject[UserPreference] }

  trait Store { def store() }

  trait MemoryStore extends Store { def store() = print("memory") }
  trait RemoteStore extends Store { def store() = print("remote") }

  trait User extends Store
  trait UserPreference extends Store
}
package controllers

import com.google.inject.Inject
import models.{User, Users}
import play.api.db.slick.DatabaseConfigProvider
import play.api.mvc.{Action, Controller}
import slick.jdbc.PostgresProfile
//import slick.jdbc. //.{JdbcProfile, PostgresDriver}

//import slick.driver.PostgresDriver.api._
import scala.concurrent.Future
import play.api.libs.concurrent.Execution.Implicits._

/**
  * Created by patwhite on 5/17/17.
  */
class ApplicationController @Inject()(dbConfigProvider: DatabaseConfigProvider) extends Controller {
  val dbConfig = dbConfigProvider.get[PostgresProfile]

  import dbConfig.profile.api._

  def index(id: Int) = Action.async { implicit request =>
    val resultingUsers: Future[Seq[User]] = dbConfig.db.run(Users.users.filter(_.id === id).result)
    resultingUsers.map(users => Ok)
  }
}

package models

import slick.jdbc.PostgresProfile.api._
//import slick.lifted.{TableQuery, Tag}

import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by patwhite on 5/17/17.
  */
case class User(id: Option[Int], email: String, passwordHash: String)

class Users(tag: Tag) extends Table[User](tag, "users") {
  def id = column[Int]("id", O.PrimaryKey)
  def first = column[String]("first")
  def last = column[String]("last")
  def * = (id.?, first, last) <> (User.tupled, User.unapply)
}

object Users {
  val users = TableQuery[Users]
}

package models

import java.sql.Timestamp

case class User(id:Option[Int], name:String, email:String, password:String, create_date:Timestamp);
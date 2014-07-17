package models

import play.Play

object AppConf {
  
  def getDb(dbName:String, key:String) = {
    Play.application.configuration.getString("db.%s.%s".format(dbName, key))
  }
  
  def get(key:String) = {
    Play.application.configuration.getString(key)
  }
}
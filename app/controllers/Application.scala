package controllers

import play.api._
import play.api.mvc._
import models.Campaign
import scala.reflect.runtime.{universe => ru}
import ru._


object Application extends Controller {

  def index = Action {
    Campaign(0, "campaign1", Some(10000), Some(1000000), Some(1)).add
    val datas = Campaign.SelectAll
    
    Ok(views.html.index("Your new application is ready.", datas))
  }

}
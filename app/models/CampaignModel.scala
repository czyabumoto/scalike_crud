package models

import scalikejdbc._

case class Campaign(campaign_id:Int, campaign_name:String, daily_budget:Option[Int], total_budget:Option[Int], status:Option[Int]) {
  
  ConnectionPool.singleton(AppConf.getDb("default", "url"), AppConf.getDb("default", "user"), AppConf.getDb("default", "password"))
  
  def add: Any = {
    DB localTx { implicit session => 
      withSQL {
        val c = Campaign.column
        insert.into(Campaign).namedValues(
            c.campaign_name -> this.campaign_name,
            c.daily_budget -> this.daily_budget,
            c.total_budget -> this.total_budget,
            c.status -> this.status
        )
      }.updateAndReturnGeneratedKey.apply()
    }
  }
}


object Campaign extends SQLSyntaxSupport[Campaign] {
  
  override val tableName = "campaigns"
  def apply(rs: WrappedResultSet) = new Campaign(
      rs.int("campaign_id"), rs.string("campaign_name"), rs.intOpt("daily_budget"), rs.intOpt("total_budget"), rs.intOpt("status")
  )
  
  def SelectAll:List[Campaign] = {
    val c = (Campaign.syntax("c"))
    
    DB readOnly { implicit session => 
      withSQL {
        select.from(Campaign as c).where.gt(c.status, -1)
      }.map(Campaign.apply(_)).list.apply()
    }
  }
}
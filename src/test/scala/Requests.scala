
import io.gatling.core.Predef._
import io.gatling.http.Predef.{bodyString, _}

object Requests {

  val getAll = exec(http("Get all Coaches")
    .get("/guidance/coaches")
    .check(status.is(200), jsonPath("$.coaches[*].id").findAll.saveAs("idList")
    ))
    .exec(session => {
      val maybeId = session.get("idList").asOption[String]
      //      println(maybeId.getOrElse("COULD NOT FIND ID"))

      session
    })

  val listOfCoaches = http("CoachesList").get("/guidance/coaches").check(status.is(200))

  val fundsCharts = http("FundsCharts")
    .get("/market/funds/charts/1/A")
    .check(status.is(200))

  val fundsFeesExpenses = exec(http("FundFeesExpenses")
    .get("/market/funds/fees-and-expenses/1/A")
    .check(status.is(200), bodyString.not("null")))

  val fundsUniverse = http("FundUniverse")
    .get("/market/funds/fund-universe")
    .check(status.is(200), bodyString.not("null"))

  val fundsHoldings = exec(http("FundsHoldings")
    .get("/market/funds/holdings/1/A")
    .check(status.is(200), bodyString.not("null")))

  val fundsPriceDistributions = exec(http("FundsPriceDistributions")
    .get("/market/funds/price-distributions/1/A/2018-03-01/2018-03-30")
    .check(status.is(200), bodyString.not("null")))

  val fundsResources = exec(http("FundsResources")
    .get("/market/funds/resources/1/A")
    .check(status.is(200), bodyString.not("null")))

  val fundsReturns = exec(http("FundsReturns")
    .get("/market/funds/returns/1/A")
    .check(status.is(200), bodyString.not("null")))

  val fundsRiskRatings = exec(http("FundsRiskRatings")
    .get("/market/funds/risk-ratings/1/A")
    .check(status.is(200), bodyString.not("null")))

  val fundsSummary = exec(http("FundsSummary")
    .get("/market/funds/summary/1/A")
    .check(status.is(200), bodyString.not("null")))

}

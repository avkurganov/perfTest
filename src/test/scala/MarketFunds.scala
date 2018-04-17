import Requests._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class MarketFunds extends Simulation {

  val httpConf = http.baseURL("https://dev.esi.bcgdv.ventures")

  val scn1 = scenario("GetFundsCharts").exec(fundsCharts)
  val scn2 = scenario("GetFundsFeesAndExpenses").exec(fundsFeesExpenses)
  val scn3 = scenario("GetFundsUniverse").exec(fundsUniverse)
  val scn4 = scenario("GetFundsHoldings").exec(fundsHoldings)
  val scn5 = scenario("GetFundsPriceDistributions").exec(fundsPriceDistributions)
  val scn6 = scenario("GetFundsResources").exec(fundsResources)
  val scn7 = scenario("GetFundsReturns").exec(fundsReturns)
  val scn8 = scenario("GetFundsRiskRating").exec(fundsRiskRatings)
  val scn9 = scenario("GetFundsSummary").exec(fundsSummary)


  val scn10 = scenario("FundsSuit").randomSwitch(
    11d -> exec(fundsCharts),
                11d -> exec(fundsFeesExpenses),
                11d -> exec(fundsHoldings),
                11d -> exec(fundsPriceDistributions),
                11d -> exec(fundsResources),
                11d -> exec(fundsReturns),
                11d -> exec(fundsRiskRatings),
                11d -> exec(fundsSummary),
                11d -> exec(fundsUniverse)
  )


  setUp(
    scn1.inject(constantUsersPerSec(1) during (1 seconds)).protocols(httpConf),
    scn2.inject(constantUsersPerSec(1) during (1 seconds)).protocols(httpConf),
    scn3.inject(constantUsersPerSec(1) during (1 seconds)).protocols(httpConf),
    scn4.inject(constantUsersPerSec(1) during (1 seconds)).protocols(httpConf),
    scn5.inject(constantUsersPerSec(1) during (1 seconds)).protocols(httpConf),
    scn6.inject(constantUsersPerSec(1) during (1 seconds)).protocols(httpConf),
    scn7.inject(constantUsersPerSec(1) during (1 seconds)).protocols(httpConf),
    scn8.inject(constantUsersPerSec(1) during (1 seconds)).protocols(httpConf),
    scn9.inject(constantUsersPerSec(1) during (1 seconds)).protocols(httpConf)




//                scn10.inject(constantUsersPerSec(1) during(10 seconds)).protocols(httpConf)
  )


}

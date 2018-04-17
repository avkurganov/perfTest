import io.gatling.core.Predef._
import io.gatling.http.Predef._
import Requests._

import scala.concurrent.duration._

class LoadTest extends Simulation{

  val httpConf = http.baseURL("https://dev.esi.bcgdv.ventures")

  val scn1 = scenario("GetCoachesList").exec(listOfCoaches)
  val scn3 = scenario("CoachId").exec(getAll)






    setUp(
//          scn1.inject(constantUsersPerSec(100) during(10 seconds)).protocols(httpConf),
//          scn2.inject(constantUsersPerSec(100) during(10 seconds)).protocols(httpConf),
//
//          scn5.inject(constantUsersPerSec(100) during(10 seconds)).protocols(httpConf),
            scn3.inject(constantUsersPerSec(100) during(10 seconds)).protocols(httpConf)
    )


}

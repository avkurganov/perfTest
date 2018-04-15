
import java.util.Date

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class Users extends Simulation{



  val httpConf = http.baseURL("https://dev.esi.bcgdv.ventures")

  val createUser = exec(http("Create User")
    .post("/guidance/investors")
    .body(StringBody("""{ "email": "qa_test_user_${numb}@mailinator.com" }"""))
    .asJSON
    .check(
    status.is(201)
  ))

  val date  = new Date();
  date.getTime;


//  val numbers = Iterator.continually(Map("numb" -> scala.util.Random.nextInt(Int.MaxValue)))
val numbers = Iterator.continually(Map("numb" -> s date.getTime))

  val runCreateUsers = scenario("Create Users")
    .feed(numbers)
    .exec(createUser)


  setUp(runCreateUsers.inject(constantUsersPerSec(10) during(1 seconds)).protocols(httpConf))

}

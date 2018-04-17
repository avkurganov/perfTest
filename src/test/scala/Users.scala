
import Requests._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._


class Users extends Simulation {

  import java.util

  val list = new util.ArrayList[String]

  val httpConf = http.baseURL("https://dev.esi.bcgdv.ventures")

  val httpHeader = Map("Content-Type" -> """application/json""")

  val createUser = exec(http("Create User")
    .post("/guidance/investors")
      .headers(httpHeader)
      .formParam("email", "qa_test_user_${numb}@mailinator.com")
//    .body(StringBody("""{ "email": "qa_test_user_${numb}@mailinator.com" }"""))
//    .asJSON
    .check(
      status.is(201)
    ).check(
    jsonPath("$.id").saveAs("myresponseId")
  )
  ).exec(session => {
    val maybeId = session.get("myresponseId").asOption[String]
    println(maybeId.getOrElse("COULD NOT FIND ID"))
    list.add(maybeId.get)

    session
  })


  val numbers = Iterator.continually(Map("numb" -> scala.util.Random.nextInt(Int.MaxValue)))

  //  val numbers = Iterator.continually(Map("numb" -> System.currentTimeMillis() / 1000))

  val runCreateUsers = scenario("Create Users")
    .feed(numbers)
    .exec(createUser)
    .exec(session => {

      println(list)

      session
    })

  setUp(runCreateUsers.inject(constantUsersPerSec(3) during (1 seconds)).protocols(httpConf))


}

package com.polycodal.bugreport.com.fasterxml.jackson.module.scala

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.scalatest.{FlatSpec, Matchers}

class OptionalTypeSpec extends FlatSpec with Matchers {

  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)


  it should "deserialize Ints from strings" in {
    val json = """ "42" """
    val result: Int = mapper.readValue(json, classOf[Int])
    result shouldEqual 42
  }

  it should "fail deserializing int from string that can't be parsed" in {
    an [InvalidFormatException] shouldBe thrownBy {mapper.readValue( """ "foo" """, classOf[Int])}
  }

  it should "deserialize optional ints from a string" in {
    val json = """ "42" """
    val result: Option[Int] = mapper.readValue(json, classOf[Option[Int]])
    result shouldEqual Some(42)
  }

  it should "fail deserializing optional int from string that can't be parsed" in {
    val json = """ "foo" """
    an [InvalidFormatException] shouldBe thrownBy { mapper.readValue(json, classOf[Option[Int]]) }
  }

}


package org.http4s

import org.scalatest.{OptionValues, Matchers, WordSpec}

class MethodSpec extends WordSpec with Matchers with OptionValues {
  "A standard method" should {
    "be findable by name" in {
      Method.get("GET").value should equal (Method.Get)
    }

    "be case sensitive" in {
      Method.get("get") should be (None)
    }
  }

  "PATCH" should {
    "be registered" in {
      Method.get("PATCH").value should equal (Method.Patch)
    }
  }

  "Extension methods" should {
    "not be returned by get" in {
      Method.get("huh") should be (None)
    }

    "not be registered by apply" in {
      Method("huh")
      Method.get("huh") should be (None)
    }
  }
}

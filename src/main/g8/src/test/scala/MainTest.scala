package $organization$.$name;format="lower,word"$

import org.scalatest.WordSpec

class MainTest extends WordsSpec {

    "A string" should {
        "have correct size" in {
            assert( "mystring".size === 8 )
        }
    }
}

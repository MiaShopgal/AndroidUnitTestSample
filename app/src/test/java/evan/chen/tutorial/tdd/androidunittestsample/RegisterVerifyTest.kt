package evan.chen.tutorial.tdd.androidunittestsample

import org.junit.Test

import org.junit.Assert.*

class RegisterVerifyTest {

    @Test
    fun loginVerifyTrue() {
        val registerVerify = RegisterVerify()
        assertTrue(registerVerify.isLoginIdVerify("A123456"))
    }

    @Test
    fun loginVerifyFalse() {
        val registerVerify = RegisterVerify()
        assertFalse(registerVerify.isLoginIdVerify("A1234"))
    }
}
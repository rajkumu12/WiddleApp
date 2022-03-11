package com.apps.widdleapp

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class ValidatorTest{

    @Test
    fun validinput(){
        val name="Rajeev";
        val mobile="9781767938"
        val des="9781767938"

        val result=Validator.Validateintputs(name,mobile,des)

        assertEquals(result,true)

    }

    @Test
    fun Invalidinput(){
        val name="";
        val mobile="9781767938"
        val des=""

        val result=Validator.Validateintputs(name,mobile,des)

        assertEquals(result,false)

    }
}
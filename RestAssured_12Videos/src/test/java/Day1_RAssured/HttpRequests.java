package Day1_RAssured;

import org.testng.annotations.Test;



import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

///*
//Given()=>Content Type , Set Cookie,Add authorization,Add parameters ,Set Header Information
//
//When()=> get ,put ,post =>create,delete
//
//then()+And()=>Validation of Status code ,Extract Response ,response body ,Extract header cookie
// */


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HttpRequests {
    int id;
    @Test (priority=1)//CANT BE DONE IN JUNIT
    void  getUsers(){
        given()
                .when().get("https://reqres.in/api/users?page=2")
                .then().statusCode(200).body("page",equalTo(2)).log().all();

    }

    @Test (priority=2)
    void CreateUser(){

        HashMap data =new HashMap();
        data.put("name", "morpheus");
        data.put("job", "leader");


        id=given().contentType("application/json").body(data).
        when().post("https://reqres.in/api/users").jsonPath().getInt("id");
//        then().statusCode(201).log().all();
        System.out.println(id);
    }

    @Test (priority=3)
    void UpdateUser(){
        HashMap data =new HashMap();
        data.put("name", "Swapnadip");
        data.put("job", "leader");

        given().contentType("application/json").body(data).
            when().put("https://reqres.in/api/users/"+id).
         then().statusCode(200).log().all();


    }
    @Test (priority=4)
    void DeleteUser(){
        given().when().delete("https://reqres.in/api/users/"+id)
                .then().statusCode(204).log().all();
    }
}
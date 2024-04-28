package Day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class DifferentWaysToCreatePostRequestBody {

    //1) Using HashMap
//    @Test (priority =1)
    void TestPostUsingHashMap(){

        HashMap data =new HashMap();
        data.put("name","Swapnadip");
        data.put("location","India");
        data.put("phone","12345");

        String courseArr[]={"C","C++"};

        data.put("course",courseArr);
        System.out.println(data);

//        given().contentType("application/json").body(data).
//                when().post("http://localhost:3000/students").
//                then().statusCode(201).
//                body("name",equalTo(Swapnadip)).body("location",equalTo(India)).
//                body("phone",equalTo("12345")).body("course[0]",equalTo("C")).
//                body("course[1]",equalTo("C++")).
//                header("content-type","application/json, charset=utf-8").log().all();

    }
//2) Using Org.Json library .body(data.toString())
//    @Test (priority =1)
    void TestPostUsingJsonLibrary(){

        JSONObject data=new JSONObject();
        data.put("name","Swapnadip");
        data.put("location","India");
        data.put("phone","12345");

        String courseArr[]={"C","C++"};

        data.put("course",courseArr);
        System.out.println(data);

//        given().contentType("application/json").body(data.toString()).
//                when().post("http://localhost:3000/students").
//                then().statusCode(201).
//                body("name",equalTo(Swapnadip)).body("location",equalTo(India)).
//                body("phone",equalTo("12345")).body("course[0]",equalTo("C")).
//                body("course[1]",equalTo("C++")).
//                header("content-type","application/json, charset=utf-8").log().all();

    }

    //3) Using POJO Class post Request
    // will not work System.out.println(data);
    //@Test (priority =1)
    void TestPostUsingPOJO(){

        POGO_PostRequest data = new POGO_PostRequest();
        data.setName("Swapnadip");
        data.setLocation("India");
        data.setPhone("12345");

        String courseArr[]={"C","C++"};

        data.setCourses(courseArr);


//        given().contentType("application/json").body(data).
//                when().post("http://localhost:3000/students").
//                then().statusCode(201).
//                body("name",equalTo(Swapnadip)).body("location",equalTo(India)).
//                body("phone",equalTo("12345")).body("course[0]",equalTo("C")).
//                body("course[1]",equalTo("C++")).
//                header("content-type","application/json, charset=utf-8").log().all();

    }

    //4) Using External Json post Request
    // will not work System.out.println(data);
    @Test (priority =1)
    void TestPostUsingExternalJson() throws FileNotFoundException {

        File f= new File("C:\\Users\\Swapnadip\\IdeaProjects\\RestAssured_12Videos\\target\\body.json"); //File is opened
        FileReader fr=new FileReader(f);//read the file import from import Java.io package
        JSONTokener jt =new JSONTokener(fr); //import JSON.org
        JSONObject data =new JSONObject(jt);

        System.out.println(data);






//        given().contentType("application/json").body(data.toString()).
//                when().post("http://localhost:3000/students").
//                then().statusCode(201).
//                body("name",equalTo(Swapnadip)).body("location",equalTo(India)).
//                body("phone",equalTo("12345")).body("course[0]",equalTo("C")).
//                body("course[1]",equalTo("C++")).
//                header("content-type","application/json, charset=utf-8").log().all();

    }
    @Test (priority=2)

    void DeleteUser(){
        given().
                when().delete("http://localhost:3000/students").
                then().statusCode(200);
    }


}

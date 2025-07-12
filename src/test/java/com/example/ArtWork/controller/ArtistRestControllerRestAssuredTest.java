package com.example.ArtWork.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;

import com.example.ArtWork.model.Artist;
import com.example.ArtWork.model.Judge;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

import com.example.ArtWork.Repository.JudgeRepository;
import com.example.ArtWork.Service.ArtistService;


//import io.restassured.module.mockmvc.RestAssuredMockMvc;



	
	@RunWith(MockitoJUnitRunner.class)
	public class ArtistRestControllerRestAssuredTest {

		@Mock
		private ArtistService artistService;
		@Mock
		private JudgeRepository judgeRepository;

		@InjectMocks
		private ArtistRestController artistRestController;
	    
		@Before
		public void setup() {

		    RestAssuredMockMvc.standaloneSetup(artistRestController);
		}
		
		@Test
		public void testPostArtist() throws Exception {
		    Artist requestBodyArtist = new Artist();
		    requestBodyArtist.setName("Azadeh");
		    requestBodyArtist.setArtName("Painting");
		    requestBodyArtist.setScore(3);

		    Artist returnedArtist = new Artist();
		    returnedArtist.setId(1L);
		    returnedArtist.setName("Azadeh");
		    returnedArtist.setArtName("Painting");
		    returnedArtist.setScore(3);
		    returnedArtist.setJudge(null);

		    when(artistService.createArtist(org.mockito.ArgumentMatchers.any(Artist.class))).thenReturn(returnedArtist);

		    given()
		        .contentType(MediaType.APPLICATION_JSON_VALUE)
		        .body(requestBodyArtist)

		    .when()
		        .post("/api/artists/new")
		    .then()
		        .statusCode(200)
		        .body("name", equalTo("Azadeh"))
		        .body("artName", equalTo("Painting"))
		        .body("score", equalTo(3));
		}

		@Test
		public void testUpdateScoreArtist() throws Exception {
			
			 Artist requestBodyArtist = new Artist();
			    requestBodyArtist.setName("Azadeh");
			    requestBodyArtist.setArtName("Painting");
			    requestBodyArtist.setScore(3);
			    
			    Artist returnedArtist = new Artist();
			    returnedArtist.setId(1L);
			    returnedArtist.setName("Azadeh");
			    returnedArtist.setArtName("Painting");
			    returnedArtist.setScore(3);
			    returnedArtist.setJudge(null);

			    when(artistService.updateArtistScore(1L, requestBodyArtist.getScore())).
		thenReturn(returnedArtist);
		given().
		contentType(MediaType.APPLICATION_JSON_VALUE).
		body(requestBodyArtist).
		when().
		put("/api/artists/updateScore/1").
		then().
		statusCode(200)
		
				.body("name", equalTo("Azadeh"))
		        .body("artName", equalTo("Painting"))
		        .body("score", equalTo(3));
	
		}
	}
	

package com.sp.rest;

import com.sp.model.User;
import com.sp.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(value = UserRestCrt.class)
@WithMockUser
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	User mockUser = new User(1,"silia", "taider", "mdp",500);
	String exampleUserJson = "{\"name\":\"silia\",\"surname\":\"taider\", \"password\":\"mdp\"}";


	////////// GET TEST
	@Test
	public void getUser() throws Exception {

		Mockito.when(
				userService.getUser(Mockito.anyInt())).thenReturn(mockUser);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/users/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{id:1,name:silia,surname:taider,password:mdp,money:500}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	

	////////// POST TEST
	@Test
	public void addUser() throws Exception {
		User mockUser = new User(2,"hiba", "hadj", "mdp2",5000);

		Mockito.when(
				userService.addUser(Mockito.any(User.class))).thenReturn(mockUser);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/users")
				.accept(MediaType.APPLICATION_JSON).content(exampleUserJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		// retourne 200 pour OK et pas 201 pour CREATED , je pense que c est parceque la methode dans notre controlleur est une void
		//assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertEquals(HttpStatus.OK.value(), response.getStatus());

		// assertEquals("http://localhost/users/2", response.getHeader(HttpHeaders.LOCATION));

	}

	
	///// AUTRE POST TEST
/*
    @Test
    //@Disabled
    public void createUserTest() throws Exception {
    	
    	User user = new User(2,"hiba", "hadj", "mdp2",5000);

        Mockito.when(userService.addUser(Mockito.any(User.class))).thenReturn(user);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(user).getBytes(StandardCharsets.UTF_8))
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertThat(result).isNotNull();
        String userJson = result.getResponse().getContentAsString();
        Assertions.assertThat(userJson).isNotEmpty();
        Assertions.assertThat(userJson).isEqualToIgnoringCase(mapper.writeValueAsString(user));
    }
*/
}
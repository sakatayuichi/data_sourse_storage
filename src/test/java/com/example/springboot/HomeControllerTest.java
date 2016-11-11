package com.example.springboot;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class HomeControllerTest {

	@Autowired
	WebApplicationContext wac;
	MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


	@Test
	public void test_Status_200_OK() throws Exception {					//レスポンスが20X系のチェック
		mockMvc.perform(post("/service")).andExpect(status().isOk());
	}

	@Test
	public void test_JSON_Response() throws Exception {
		mockMvc.perform(post("/service").contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void test_top() throws Exception {					//topのテスト
		//List<String> JsonData = new ArrayList<String>();
		//HomeModel02 model02 = {"starttimehour:9","endtimehour:12"};
		//HomeModel02 bean = new HomeModel02();
		MvcResult result = mockMvc.perform(post("/service")
										.accept(MediaType.APPLICATION_JSON)
										.contentType(MediaType.ALL)
										.param("starttimehour","9")
										.param("endtimehour","21")
										.param("starttimeminute","00")
										.param("endtimeminute","12"))
										.andReturn();

		assertThat(result.getResponse().getContentAsString(),is("勤務時間:12:12"));
		/*mockMvc.perform(post("/service").contentType(MediaType.APPLICATION_JSON).param("endtimehour","21"))
										.equals(bean.getendtimehour());
		mockMvc.perform(post("/service").contentType(MediaType.APPLICATION_JSON).param("starttimeminute","00"))
										.equals(bean.getstarttimeminute());
		mockMvc.perform(post("/service").contentType(MediaType.APPLICATION_JSON).param("endtimeminute","12"))
										.equals(bean.getendtimeminute());*/
		//HomeController controller = new HomeController();
		//JSONArray response = new JSONArray();
		//JsonData = controller.top(model02);

	}

}

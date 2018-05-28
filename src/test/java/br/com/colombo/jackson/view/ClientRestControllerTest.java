package br.com.colombo.jackson.view;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author carloshenrique
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientRestControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void getWithPublicView() {
		// Arrange
		// Act
		final String object = this.testRestTemplate.getForObject("/public-client", String.class);
		// Assert
		log.info("JSON: {}", object);
		assertThat(object, not(containsString("identify")));
	}

	@Test
	public void getWithPrivateView() {
		// Arrange
		// Act
		final String object = this.testRestTemplate.getForObject("/private-client", String.class);
		// Assert
		log.info("JSON: {}", object);
		assertThat(object, containsString("identify"));
	}
}

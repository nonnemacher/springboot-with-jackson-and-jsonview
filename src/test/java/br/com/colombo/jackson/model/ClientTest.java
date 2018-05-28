package br.com.colombo.jackson.model;

import br.com.colombo.jackson.view.View;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * @author carloshenrique
 */
@Slf4j
public class ClientTest {

	private static ObjectMapper objectMapper;

	@BeforeClass
	public static void beforeClass() {
		objectMapper = new ObjectMapper();
	}

	@Test
	public void writeValueAsStringWithViewPublic() throws JsonProcessingException {
		// Arrange
		final Client client = this.getClient();

		// Act
		final String object = objectMapper
				.writerWithView(View.Public.class)
				.writeValueAsString(client);

		// Assert
		log.info("JSON: {}", object);
		assertThat(object, containsString("name"));
		assertThat(object, not(containsString("identify")));

	}

	@Test
	public void writeValueAsStringWithViewPrivate() throws JsonProcessingException {
		// Arrange
		final Client client = this.getClient();

		// Act
		final String object = objectMapper
				.writerWithView(View.Private.class)
				.writeValueAsString(client);

		// Assert
		log.info("JSON: {}", object);
		assertThat(object, containsString("name"));
		assertThat(object, containsString("identify"));

	}

	private Client getClient() {
		return Client.builder()
				.identify("123456")
				.name("Carlos Henrique Nonnemacher")
				.build();
	}

}

package br.com.colombo.jackson.view;

import br.com.colombo.jackson.model.Client;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRestController {

	@GetMapping("/public-client")
	@JsonView(View.Public.class)
	public ResponseEntity<Client> getPublic() {
		return ResponseEntity.ok(getClient());
	}

	@GetMapping("/private-client")
	@JsonView(View.Private.class)
	public ResponseEntity<Client> getPrivate() {
		return ResponseEntity.ok(this.getClient());
	}

	private Client getClient() {
		return Client.builder()
				.identify("123456")
				.name("Carlos Henrique Nonnemacher")
				.build();
	}

}

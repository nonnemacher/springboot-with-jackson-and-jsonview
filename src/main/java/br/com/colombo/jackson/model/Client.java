package br.com.colombo.jackson.model;

import br.com.colombo.jackson.view.View.Private;
import br.com.colombo.jackson.view.View.Public;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import lombok.*;

/**
 * @author carloshenrique
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

	@JsonView({Public.class, Private.class})
	private String name;

	@JsonView(Private.class)
	private String identify;

}

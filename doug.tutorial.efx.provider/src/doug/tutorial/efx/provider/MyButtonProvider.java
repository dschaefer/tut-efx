package doug.tutorial.efx.provider;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import doug.tutorial.efx.IButtonProvider;

public class MyButtonProvider implements IButtonProvider {

	public MyButtonProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Button createButton() {
		Button btn = new Button();
		btn.setText("Say 'Hello World ext'");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World ext!");
			}
		});

		return btn;
	}

}

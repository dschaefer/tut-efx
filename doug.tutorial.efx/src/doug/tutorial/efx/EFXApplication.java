package doug.tutorial.efx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class EFXApplication extends Application implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
		launch();
		return IApplication.EXIT_OK;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello World!");
		StackPane root = new StackPane();

		IConfigurationElement[] elements
			= Platform.getExtensionRegistry().getConfigurationElementsFor(Activator.PLUGIN_ID, "buttonProvider");
		for (IConfigurationElement element : elements) {
			Object o = element.createExecutableExtension("class");
			if (o instanceof IButtonProvider) {
				Button btn = ((IButtonProvider) o).createButton();
				root.getChildren().add(btn);
			}
		}
		
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
	
	@Override
	public void stop() {
	}

}

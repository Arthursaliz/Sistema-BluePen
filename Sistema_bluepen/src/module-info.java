module Sistema_bluepen {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	exports packageController;
	exports packageModel;
	exports packageControle;
	
	opens packageController to javafx.fxml;
	opens packageModel to javafx.fxml;
	opens packageControle to javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}

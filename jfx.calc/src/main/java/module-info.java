module com.japps.jfx.calc {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
	requires org.apache.logging.log4j.core;
	requires org.apache.commons.lang3;
	requires com.japps.lib.math;
    
    opens com.japps.jfx.calc.app to javafx.fxml;
    opens com.japps.jfx.calc.controller to javafx.fxml;
    exports com.japps.jfx.calc.app;
}

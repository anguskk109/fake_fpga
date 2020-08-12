package GUI.device;

import Controller.Device;
import GUI.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class Switch extends VBox {
    private final CheckBox checkBox;

    public Switch(int index){
        super();
        checkBox = new CheckBox();
        checkBox.selectedProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                Main.connector.sendSignal(Device.SW + " " + index + " " + (newValue ? 1 : 0));
            }
        });
        Label label = new Label("  " + index);
        label.setTextAlignment(TextAlignment.CENTER);
        this.getChildren().add(checkBox);
        this.getChildren().add(label);
    }



    /**
     * Setters and Getters
     */

    public boolean getStatus(){
        return this.checkBox.isSelected();
    }

    public void setStop(){
        this.checkBox.setSelected(false);
    }
}

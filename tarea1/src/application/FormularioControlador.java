package application;

import java.net.URL;
import java.util.ResourceBundle;

import clases.Computadora;
import clases.Informacion;
import clases.SmartTV;
import clases.Telefono;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class FormularioControlador implements Initializable {

	private ObservableList<Telefono> telefonos;
	private ObservableList<Computadora> computadoras;
	private ObservableList<SmartTV> televisores;
	private ObservableList<String> marcas;
	private ObservableList<String> modelos;
	private ObservableList<String> sistemasOperativos;
	private ObservableList<String> objetos;
	
	//@FXML private ComboBox<>
	@FXML private TextField capasidadMemoria;
	@FXML private TextField capasidadDisco;
	@FXML private TextField resolucion;
	@FXML private TextField tamanioPantalla;
	@FXML private TextField numeroTelefonico;
	@FXML private TextField capasidadCamara;
	@FXML private ComboBox<String> cboMarca;
	@FXML private ComboBox<String> cboModelo;
	@FXML private ComboBox<String> cboSistemaOp;
	@FXML private ComboBox<String> cboObjeto;
	@FXML private ListView<Informacion> lstInformacion;
	@FXML private RadioButton rbtTigo;
	@FXML private RadioButton rbtClaro;
	@FXML private RadioButton rbtHondutel;
	@FXML private CheckBox chbNFC;
	@FXML private CheckBox chbLTE;
	@FXML private CheckBox chbBluetooth;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		objetos = FXCollections.observableArrayList();
		marcas = FXCollections.observableArrayList();
		modelos = FXCollections.observableArrayList();
		sistemasOperativos = FXCollections.observableArrayList();
		
		objetos.add("Telefonos");
		objetos.add("SmartTV");
		objetos.add("Computadoras");
		cboObjeto.setItems(objetos);
		
		lstInformacion.setItems(null);
		
		cboObjeto.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				System.out.println("Valor actual: "+arg2);
				
			}
			
		});
		
		/*marcas.add("Sony");
		marcas.add("Samsung");
		marcas.add("Apple");
		marcas.add("Motorola");
		marcas.add("Huawei");*/
	}
	
	@FXML
	public void salir() {
		System.exit(0);
	}
}

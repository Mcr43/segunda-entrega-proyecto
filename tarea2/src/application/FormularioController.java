package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import clases.Empleado;
import clases.Profesion;
import clases.Supervisor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class FormularioController implements Initializable{
	private ObservableList<Empleado> empleados;
	private ObservableList<Profesion> profesiones;
	private ObservableList<Supervisor> supervisores;
	@FXML private TextField txfNombre;
	@FXML private TextField txfApellido;
	@FXML private TextField txfEdad;
	@FXML private ComboBox<Profesion> cboProfecion;
	@FXML private ComboBox<Supervisor> cboSupervisor;
	@FXML private RadioButton rbtFemenino;
	@FXML private RadioButton rbtMasculino;
	@FXML private RadioButton rbtContratado;
	@FXML private RadioButton rbtDespedido;
	
	@FXML private Button btnNuevo;
	@FXML private Button btnGuardar;
	@FXML private Button btnActualizar;
	
	private ArrayList<String> errores;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		empleados = FXCollections.observableArrayList();
		profesiones = FXCollections.observableArrayList();
		supervisores = FXCollections.observableArrayList();
		errores = new ArrayList<String>();
		
		supervisores.add(new Supervisor("Juan", "Perez", 35, "Masculino", 7, "Contabilidad"));
		supervisores.add(new Supervisor("Genesis", "Martinez", 29, "Femenino", 5, "Ciber Seguridad"));
		supervisores.add(new Supervisor("Mario", "perez", 43, "Masculino", 3, "Correo"));
		
	}
	
	
	
}
